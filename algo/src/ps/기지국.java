package ps;
/**
 * @since 2021. 2. 7.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기지국 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N;
	static char[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new char[N + 1][N];
			for (int r = 0; r < N + 1; r++) {
				char[] line = input.readLine().toCharArray();
				for (int c = 0; c < N; c++) {
					map[r][c] = line[c];
				}
			}
			// 입력확인
//			for (char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}

			for (int r = 0; r < N + 1; r++) {
				for (int c = 0; c < N; c++) {

					if (map[r][c] == 'A' || map[r][c] == 'B' || map[r][c] == 'C') {
						int val = map[r][c] - 'A' + 1;
						for (int v = 1; v <= val; v++) {
							for (int d = 0; d < deltas.length; d++) {
								int nr = r + deltas[d][0] * val;
								int nc = c + deltas[d][1] * val;
								if (isIn(nr, nc) && map[nr][nc] == 'H') {
									map[nr][nc] = 'X';
								}
							}
						}
					}
				}
			}
			int cnt = 0;
			for (int r = 0; r < N + 1; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'H')
						cnt++;
				}
			}
			output.append("#" + t + " " + cnt);
			System.out.println(output);
		}
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N + 1 && 0 <= c && c < N;
	}
}