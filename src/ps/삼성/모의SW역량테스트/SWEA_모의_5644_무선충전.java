
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2019. 4. 2.
 * @see https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo
 * @mem 25,160 kb
 * @time 134 ms
 * @caution $시뮬레이션, 
 * 한 영역에 둘이 들어왔을 때 분배할 필요가 없다. 왜냐하면 총 량을 구할꺼니까.
 */
public class SWEA_모의_5644_무선충전 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    private static int T;
    private static int M; // 총 이동 시간
    private static int BC; // Battery Charger의 개수
    private static User[] MA, MB;// A와 B의 이동 경로
    private static BatteryCharger[] spots;
    
    // 0: 이동하지 않음, 1: 상, 2:우, 3: 하, 4: 
    static int dirs[][] = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int power;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        T = Integer.parseInt(input.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer tokens = new StringTokenizer(input.readLine());
            M = Integer.parseInt(tokens.nextToken());// 이동 시간
            BC = Integer.parseInt(tokens.nextToken());// 배터리 차저 개수

            MA = new User[M + 1];
            MB = new User[M + 1];

            // MA와 MB의 초기 위치는 고정되어있다.
            MA[0] = new User(1, 1, 0);
            MB[0] = new User(10, 10, 0);

            updateMovePath(new StringTokenizer(input.readLine()), MA);
            updateMovePath(new StringTokenizer(input.readLine()), MB);

            // 배터리 충전소 설정
            spots = new BatteryCharger[BC];

            for (int i = 0; i < BC; i++) {
                tokens = new StringTokenizer(input.readLine());
                spots[i] = new BatteryCharger(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken());
            }

            // 이제 MA와 MB가 쭉 돌면서 그 시간대에 갈 수 있는 BC가 있었는지 업데이트 해보자.
            checkSpot(MA);
            checkSpot(MB);

            // 이제 시간대별로 쭉 돌면서 충전량을 가져와 볼까..
            power = 0;
            for (int i = 0; i <= M; i++) {
                // 가장 쎈놈 하나씩 가져오기
                BatteryCharger bca = MA[i].charger.poll();
                BatteryCharger bcb = MB[i].charger.poll();

                // 둘 다 null인 경우
                if (bca == null && bcb == null) {
                    continue;
                }
                // bcb만 있는 경우
                else if (bca == null && bcb != null) {
                    power += bcb.power;
                }
                // bca만 있는 경우
                else if (bca != null && bcb == null) {
                    power += bca.power;
                }
                // 둘 다 있는 경우
                else {
                    // 근데 하필 둘이 같네..
                    if (bca.equals(bcb)) {
                        // 나눠쓰더라도 어차피 합하면 같으니까 그냥 power 일단 더해주고.
                        power += bca.power;
                        // 둘 다 있을 때는 이인자의 대결
                        BatteryCharger bca2 = MA[i].charger.poll();
                        BatteryCharger bcb2 = MB[i].charger.poll();

                        if (bca2 != null && bcb2 != null) {
                            power += Math.max(bca2.power, bcb2.power);
                        } else {
                            power += (bca2 == null ? (bcb2 == null ? 0 : bcb2.power) : bca2.power);
                        }
                    }
                    // 둘이 다른 경우
                    else {
                        power += (bca.power + bcb.power);
                    }
                }
            }
            output.append("#").append(t).append(" ").append(power).append("\n");

        }
        System.out.println(output);
    }

    // 사용자가 사용할 수 있는 BC를 등록해주자.
    private static void checkSpot(User[] users) {
        for (int i = 0; i <= M; i++) {
            User user = users[i];
            for (BatteryCharger spot : spots) {
                if (spot.canCharge(user.row, user.col)) {
                    user.charger.offer(spot);
                }
            }
        }
    }

    private static void updateMovePath(StringTokenizer tokens, User[] users) {
        // 다음 이동부터 업데이트 해주기
        for (int i = 1; i <= M; i++) {
            // 사용자가 이동한 방위
            int dir = Integer.parseInt(tokens.nextToken());
            // 기존 위치를 기반으로 새로운 위치 지정
            User prev = users[i - 1];
            users[i] = new User(prev.row + dirs[dir][0], prev.col + dirs[dir][1], i);
        }
    }

    static class User {
        int row, col, time;
        PriorityQueue<BatteryCharger> charger;

        public User(int row, int col, int time) {
            super();
            this.row = row;
            this.col = col;
            this.time = time;
            this.charger = new PriorityQueue<>();
        }

        @Override
        public String toString() {
            return "[(" + row + "," + col + "), " + time + ", c=" + charger + "]";
        }
    }

    static class BatteryCharger implements Comparable<BatteryCharger> {
        int row, col, dist, power;

        // column 다음에 row가 들어오는거 조심
        public BatteryCharger(String col, String row, String dist, String power) {
            this.row = Integer.parseInt(row); // row 좌표
            this.col = Integer.parseInt(col); // col 좌표
            this.dist = Integer.parseInt(dist); // 충전 거리
            this.power = Integer.parseInt(power); // 파워
        }

        public boolean canCharge(int userR, int userC) {
            return (Math.abs(row - userR) + Math.abs(col - userC)) <= dist;
        }

        // 파워에 대한 내림차순 정렬
        @Override
        public int compareTo(BatteryCharger o) {
            return Integer.compare(o.power, power);
        }

        @Override
        public String toString() {
            return "BatteryCharger [row=" + row + ", col=" + col + ", dist=" + dist + ", power=" + power + "]";
        }
    }
    // END:

    static String src = "5\r\n" +
                        "20 3\r\n" +
                        "2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3\r\n" +
                        "4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3\r\n" +
                        "4 4 1 100\r\n" +
                        "7 10 3 40\r\n" +
                        "6 3 2 70\r\n" +
                        "40 2\r\n" +
                        "0 3 0 3 3 2 2 1 0 4 1 3 3 3 0 3 4 1 1 3 2 2 2 2 2 0 2 3 2 2 3 4 4 3 3 3 2 0 4 4 \r\n" +
                        "0 1 0 3 4 0 4 0 0 1 1 1 0 1 4 4 4 4 4 3 3 3 0 1 0 4 3 2 1 4 4 3 2 3 2 2 0 4 2 1 \r\n" +
                        "5 2 4 140\r\n" +
                        "8 3 3 490\r\n" +
                        "60 4\r\n" +
                        "0 3 3 3 0 1 2 2 2 1 2 2 3 3 4 4 0 3 0 1 1 2 2 3 2 2 3 2 2 0 3 0 1 1 1 4 1 2 3 3 3 3 3 1 1 4 3 2 0 4 4 4 3 4 0 3 3 0 3 4 \r\n" +
                        "1 1 4 1 1 1 1 1 1 4 4 1 2 2 3 2 4 0 0 0 4 3 3 4 3 3 0 1 0 4 3 0 4 3 2 3 2 1 2 2 3 4 0 2 2 1 0 0 1 3 3 1 4 4 3 0 1 1 1 1 \r\n" +
                        "6 9 1 180\r\n" +
                        "9 3 4 260\r\n" +
                        "1 4 1 500\r\n" +
                        "1 3 1 230\r\n" +
                        "80 7\r\n" +
                        "2 2 2 2 2 2 0 2 2 0 4 0 2 3 3 2 3 3 0 3 3 3 4 3 3 2 1 1 1 0 4 4 4 1 0 2 2 2 1 1 4 1 2 3 4 4 3 0 1 1 0 3 4 0 1 2 2 2 1 1 3 4 4 4 4 4 4 3 2 1 4 4 4 4 3 3 3 0 3 3 \r\n" +
                        "4 4 1 1 2 1 2 3 3 3 4 4 4 4 4 1 1 1 1 1 1 1 1 0 3 3 2 0 4 0 1 3 3 3 2 2 1 0 3 2 3 4 1 0 1 2 2 3 2 0 4 0 3 4 1 1 0 0 3 2 0 0 4 3 3 4 0 4 4 4 4 0 3 0 1 1 4 4 3 0 \r\n" +
                        "4 3 1 170\r\n" +
                        "10 1 3 240\r\n" +
                        "10 5 3 360\r\n" +
                        "10 9 3 350\r\n" +
                        "9 6 2 10\r\n" +
                        "5 1 4 350\r\n" +
                        "1 8 2 450\r\n" +
                        "100 8\r\n" +
                        "2 2 3 2 0 2 0 3 3 1 2 2 2 2 3 3 0 4 4 3 2 3 4 3 3 2 3 4 4 4 2 2 2 0 2 2 4 4 4 4 1 1 1 2 2 2 4 3 0 2 3 3 4 0 0 1 1 4 1 1 1 1 2 2 1 1 3 3 3 0 3 2 3 3 0 1 3 3 0 1 1 3 3 4 0 4 1 1 2 2 4 0 4 1 1 2 2 1 1 1 \r\n" +
                        "4 4 4 0 4 1 1 4 1 1 1 1 3 2 1 2 1 1 4 4 1 0 2 3 4 4 4 4 4 0 1 0 2 2 2 0 2 2 2 2 2 2 3 0 0 1 4 3 3 2 0 0 4 4 4 0 2 0 4 1 1 2 2 0 4 4 0 0 2 0 2 3 3 0 2 3 0 3 4 0 4 3 4 4 3 4 1 1 2 2 2 0 0 1 0 4 1 1 1 4 \r\n" +
                        "3 4 2 340\r\n" +
                        "10 1 1 430\r\n" +
                        "3 10 4 10\r\n" +
                        "6 3 4 400\r\n" +
                        "7 4 1 80\r\n" +
                        "4 5 1 420\r\n" +
                        "4 1 2 350\r\n" +
                        "8 4 4 300\r\n" +
                        "";
}
