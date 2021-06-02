import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 빌딩 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N, cnt, res;
	static char[][] arr;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			res = 0;
			N = Integer.parseInt(input.readLine());
			arr = new char[N][N];
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = tokens.nextToken().charAt(0);
				}
			}
//			for (char[] c : arr) {
//				System.out.println(Arrays.toString(c));
//			}
			// 입력완료

			// B 빌딩세울수있음
			// G 인접한 구획에 G있으면 2층높이가능, 없으면 현 위치의 가로 위치에 있는 빌딩구획 B와 세로위치 구획 B의 수를 더한 크기만큼 세울 수
			// 있음
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cnt = 2;
					if (arr[r][c] == 'B')
						search(r, c);
				}
			}
			System.out.println(res - 1);
		}
	}

	private static void search(int r, int c) {
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if (isIn(nr, nc)) {
				if (arr[nr][nc] == 'G') {
					return;
				} else { // B일때
					if(d<4)
					go(nr, nc, d);
				}
			}

		}
		res = Math.max(res, cnt);

	}

	private static void go(int r, int c, int d) {
		if (arr[r][c] == 'B')
			cnt++;

		int nr = r + deltas[d][0];
		int nc = c + deltas[d][1];
		if (isIn(nr, nc)) {
			go(nr, nc, d);
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	// 7 7 5
	static String src = "3\r\n" + "6\r\n" + "G B G G B B\r\n" + "G B G G B G \r\n" + "B B B B G B\r\n"
			+ "B G B B B B\r\n" + "G B B B B G\r\n" + "G B B B B G\r\n" + "5\r\n" + "G B G G B \r\n" + "G B G G B  \r\n"
			+ "B B B B G \r\n" + "B G B B B \r\n" + "G B B B B \r\n" + "3\r\n" + "G G B\r\n" + "G B B\r\n" + "B B B";
}
