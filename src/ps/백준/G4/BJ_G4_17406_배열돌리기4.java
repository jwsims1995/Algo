package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 2. 10.
 * @see 
 * @mem 
 * @time 
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class BJ_G4_17406_배열돌리기4 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, K, MIN;
    static int[][] map;

    static Rotate[] rotates;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        // 배열의 크기 N, M: 3<= N,M <=50
        N = Integer.parseInt(tokens.nextToken()) + 1;// 0,0이 아닌 1,1에서 시작함
        M = Integer.parseInt(tokens.nextToken()) + 1;
        K = Integer.parseInt(tokens.nextToken());

        // 1<= maps[i][j] <= 100
        map = new int[N][M];
        for (int i = 1; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 1; j < M; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        // 내용 확인

        // 회전연산 정보: 1 <= K <=6
        rotates = new Rotate[K];
        for (int k = 0; k < K; k++) {
            tokens = new StringTokenizer(input.readLine());
            rotates[k] = new Rotate(tokens);
        }
        // 입력 처리 완료
        MIN = Integer.MAX_VALUE;

        // Rotate를 적절히 배치해야 하므로 순열 rotates의 순열 필요
        makePermutation(K, new Rotate[K], new boolean[K]);

        System.out.println(MIN);
    }

    // 순열 작성
    private static void makePermutation(int toChoose, Rotate[] choosed, boolean[] visited) {
        if (toChoose == 0) {
            rotate(choosed);
            return;
        }

        for (int i = 0; i < rotates.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choosed[choosed.length-toChoose] = rotates[i];
                makePermutation(toChoose - 1, choosed, visited);
                visited[i] = false;
            }
        }
    }

    private static void rotate(Rotate[] rotates) {
        // map 정보를 오염시킬 꺼니까 원본 배열을 복사해서 써야 한다.
        int[][] copiedMap = new int[N][M];
        for (int r = 1; r < N; r++) {
            for (int c = 1; c < M; c++) {
                copiedMap[r][c] = map[r][c];
            }
            // copies[r] = map[r].clone();
        }

        for (int t = 0; t < rotates.length; t++) {
            Rotate rotate = rotates[t];
            int rs = rotate.r - rotate.s;
            int cs = rotate.c - rotate.s;
            int re = rotate.r + rotate.s;
            int ce = rotate.c + rotate.s;
            // System.out.println(rs + " : " + cs + " : " + re + " : " + ce);
            // 중앙을 중심으로 s 두께(?) 만큼 회전한다.
            for (int i = 0; i < rotate.s; i++) {
                // 맨 좌측 상단을 미리 빼놓고 맨 마지막에 사용한다(덮어써버리니까.. 그리고 회전 처리는 아래 순서대로)
                int saved = copiedMap[rs][cs];
                // 1. 왼쪽줄을 위로 이동
                for (int r = rs + 1; r <= re; r++) {
                    copiedMap[r - 1][cs] = copiedMap[r][cs];
                }
                // 2. 맨 아래쪽 왼쪽으로 이동
                for (int c = cs + 1; c <= ce; c++) {
                    copiedMap[re][c - 1] = copiedMap[re][c];
                }
                // 3. 맨 오른쪽열 아래로 이동
                for (int r = re - 1; r >= rs; r--) {
                    copiedMap[r + 1][ce] = copiedMap[r][ce];
                }
                // 4. 맨 처음 row를 오른쪽으로 이동
                for (int c = ce - 1; c >= cs; c--) {
                    copiedMap[rs][c + 1] = copiedMap[rs][c];
                }
                // 5. 빼놓은 값 삽입
                copiedMap[rs][cs + 1] = saved;

                // 6. 포위망 좁혀서 다시 하기
                rs++;
                re--;
                cs++;
                ce--;
            }
        }
        // 회전 끝났으면 계산해볼까?
        int min = Integer.MAX_VALUE;
        for (int r = 1; r < N; r++) {
            int rowSum = 0;
            for (int c = 1; c < M; c++) {
                rowSum += copiedMap[r][c];
            }
            // 스트림 쓰니까 많이 느려짐(272 --> 584)
            // int rowSum = Arrays.stream(copies[r]).sum();
            min = Math.min(min, rowSum);
        }
        MIN = Math.min(MIN, min);
    }

    static class Rotate {
        int r, c, s;

        public Rotate(StringTokenizer tokens) {
            this.r = Integer.parseInt(tokens.nextToken());
            this.c = Integer.parseInt(tokens.nextToken());
            this.s = Integer.parseInt(tokens.nextToken());
        }

        @Override
        public String toString() {
            return "[r=" + r + ", c=" + c + ", s=" + s + "]";
        }
    }

    static String src = "5 6 2\n" +
                        "1 2 3 2 5 6\n" +
                        "3 8 7 2 1 3\n" +
                        "8 2 3 1 4 5\n" +
                        "3 4 5 1 1 1\n" +
                        "9 3 2 1 4 3\n" +
                        "3 4 2\n" +
                        "4 2 1";
}
