import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점프사방 {
	static class User {
		int r;
		int c;
		int no;

		public User(int r, int c, int no) {
			super();
			this.r = r; // 시작위치 행
			this.c = c; // 시작위치 열
			this.no = no; // 횟수
		}

		@Override
		public String toString() {
			return "User [r=" + r + ", c=" + c + ", no=" + no + "]";
		}

	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, R, C, N, sum, total;
	static String[][] arr;
	static User[] user;

	// 두자리 숫자 중 앞자리는 방향 : 동남서북 1 2 3 4
	// 뒷자리는 점프칸수
	// 참가비 1000원
	// 점프 후 마지막 좌표에 적힌 숫자에 x 100이 상금
	// 상금의 총 합
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			total = 0;
			tokens = new StringTokenizer(input.readLine());
			R = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			arr = new String[R + 1][C + 1];
			user = new User[N];
			for (int r = 1; r <= R; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 1; c <= C; c++) {
					arr[r][c] = tokens.nextToken();
				}
			}
			for (int n = 0; n < N; n++) {
				tokens = new StringTokenizer(input.readLine());
				user[n] = new User(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()),
						Integer.parseInt(tokens.nextToken()));
			}
			tokens = new StringTokenizer(input.readLine());
			int I = Integer.parseInt(tokens.nextToken());
			for (int i = 0; i < I; i++) {
				arr[Integer.parseInt(tokens.nextToken())][Integer.parseInt(tokens.nextToken())] = "0";
			}
			// 입력완료
			for (String[] string : arr) {
				System.out.println(Arrays.toString(string));
			}
			System.out.println(Arrays.toString(user));

			// 시작
			for (int n = 0; n < N; n++) { // 참가자 수
				total -= 1000; //입장료 내고
				int r = user[n].r;
				int c = user[n].c;
				int no = user[n].no; //횟수
				boolean fall = false;
				
				System.out.println("시작한다 r: " + r + " c: "+c);

				
				
				for (int o = 0; o < no; o++) {
					if (!isIn(r, c) || fall) {
						break; 
					}
						switch (arr[r][c].charAt(0)) {

						case '0': // 함정에 빠짐
							fall = true;
							break;
						case '1':// 동
							int dist = arr[r][c].charAt(1) - '0';
							c = c + dist;
							System.out.println("r: " + r + "c: "+c);
							break;
						case '2':// 남
							dist = arr[r][c].charAt(1) - '0';
							r = r + dist;
							System.out.println("r: " + r + "c: "+c);							
							break;
						case '3':// 서
							dist = arr[r][c].charAt(1) - '0';
							c = c - dist;
							System.out.println("r: " + r + "c: "+c);							
							break;
						case '4':// 북
							dist = arr[r][c].charAt(1) - '0';
							r = r - dist;
							System.out.println("r: " + r + "c: "+c);							
							break;
						}
					
				}
				if (isIn(r, c)) {
					total += Integer.parseInt(arr[r][c]) * 100;
				}
			}
			output.append("#").append(t).append(" ").append(total).append("\n");
		}
		System.out.println(output);

	}

	private static boolean isIn(int r, int c) {
		return r >= 1 && r <= R && c >= 1 && c <= C;
	}

	// 2300 -900 1500
	static String src = "3\r\n" + "6 6 2\r\n" + "34 42 22 32 21 24\r\n" + "22 32 21 33 33 33\r\n"
			+ "13 11 12 21 43 13\r\n" + "34 23 22 24 32 11\r\n" + "22 24 21 41 41 42\r\n" + "31 42 34 32 15 32\r\n"
			+ "2 3 2\r\n" + "2 6 6\r\n" + "3 3 4 4 2 6 5\r\n" +

			"2 2 3\r\n" + "11 21\r\n" + "41 31\r\n" + "1 1 2\r\n" + "2 1 2\r\n" + "1 2 1\r\n" + "1 2 2\r\n" +

			"5 6 2\r\n" + "22 32 21 33 33 33\r\n" + "13 11 12 21 43 13\r\n" + "34 23 22 24 32 11\r\n"
			+ "22 24 21 41 41 42\r\n" + "31 42 34 32 15 32\r\n" + "5 4 2\r\n" + "1 3 1\r\n" + "2 3 4 4 2";

}
