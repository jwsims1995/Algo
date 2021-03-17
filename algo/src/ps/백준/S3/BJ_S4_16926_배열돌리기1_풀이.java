package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 10.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */


public class BJ_S4_16926_배열돌리기1_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M, R;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		// 입력 완료
		// 회전 시키기
		for (int r = 0; r < R; r++) {
			rotate();
		}
		// 회전 완료
		for (int[] row : map) {
			for (int v : row) {
				output.append(v).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output);

	}

	private static void rotate() {
		// 최대 T를 찾자.
		int T = Math.min(N, M) / 2;

		for (int t = 0; t < T; t++) {
			int keep = map[t][t];
			// 윗줄 왼쪽으로 이동
			for (int c = t + 1; c < M - t; c++) {
				map[t][c - 1] = map[t][c];
			}
			// 오른쪽 위로 이동
			for (int r = t + 1; r < N - t; r++) {
				map[r - 1][M - 1 - t] = map[r][M - 1 - t];
			}
			// 아래가 오른쪽으로 이동
			for (int c = M - 1 - 1 - t; c >= t; c--) {
				map[N - 1 - t][c + 1] = map[N - 1 - t][c];
			}
			// 왼쪽이 아래로 이동
			for (int r = N - 1 - 1 - t; r >= t + 1; r--) {
				map[r + 1][t] = map[r][t];
			}
			// keep 반영
			map[t + 1][t] = keep;
		}

	}

	private static String src = "4 4 2\r\n" +
			"1 2 3 4\r\n" +
			"5 6 7 8\r\n" +
			"9 10 11 12\r\n" +
			"13 14 15 16";
}
