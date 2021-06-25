package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_4963_섬의개수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int C, R, land;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };// 8방

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		while (true) {
			String line = input.readLine();

			tokens = new StringTokenizer(line);
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			if (C == 0 && R == 0)
				break;// 0 0 이면 종료

			map = new int[R][C];
			visited = new boolean[R][C];
			land = 0;
			for (int r = 0; r < R; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			} // 입력완료

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] == 1 && !visited[r][c])// 땅이면 고고
					{
						dfs(r, c);
						land++;
					}

				}
			}

			// 출력
			output.append(land).append("\n");

		}
		System.out.println(output);

	}

	private static void dfs(int r, int c) {
		if (visited[r][c]) {
			return;
		}
		visited[r][c] = true;
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static String src = "1 1\r\n" + "0\r\n" + "2 2\r\n" + "0 1\r\n" + "1 0\r\n" + "3 2\r\n" + "1 1 1\r\n" + "1 1 1\r\n"
			+ "5 4\r\n" + "1 0 1 0 0\r\n" + "1 0 0 0 0\r\n" + "1 0 1 0 1\r\n" + "1 0 0 1 0\r\n" + "5 4\r\n"
			+ "1 1 1 0 1\r\n" + "1 0 1 0 1\r\n" + "1 0 1 0 1\r\n" + "1 0 1 1 1\r\n" + "5 5\r\n" + "1 0 1 0 1\r\n"
			+ "0 0 0 0 0\r\n" + "1 0 1 0 1\r\n" + "0 0 0 0 0\r\n" + "1 0 1 0 1\r\n" + "0 0";
}
