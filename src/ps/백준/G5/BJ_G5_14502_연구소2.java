package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14502_연구소2 {

	static class Virus {
		int r, c;

		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, ans; // 3<= R,C <= 8
	static int[][] map;
	static int[][] copyMap;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		copyMap = new int[R][C];
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력
		setWalls(3);

		System.out.println(ans);
	}

	private static void copyMap() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copyMap[r][c] = map[r][c];
			}
		}
		return;
	}

	private static void setWalls(int toChoose) {
		if (toChoose == 0) {
			ans = Math.max(ans, spread());
			return;
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					setWalls(toChoose - 1);
					map[r][c] = 0;
				}
			}
		}
	}

	private static int countSafe() {
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (copyMap[r][c] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static int spread() {
		copyMap();
		Queue<Virus> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 2) {
					queue.add(new Virus(r, c));
					visited[r][c] = true;
					while (!queue.isEmpty()) {
						Virus p = queue.poll();
						for (int d = 0; d < deltas.length; d++) {
							int nr = p.r + deltas[d][0];
							int nc = p.c + deltas[d][1];
							if (isIn(nr, nc) && !visited[nr][nc] && copyMap[nr][nc] == 0) {
								visited[nr][nc] = true;
								copyMap[nr][nc] = 2;
								queue.offer(new Virus(nr, nc));
							}
						}
					}
				}

			}
		}
		return countSafe();
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static String src = "8 8\n" + "2 0 0 0 0 0 0 2\n" + "2 0 0 0 0 0 0 2\n" + "2 0 0 0 0 0 0 2\n" + "2 0 0 0 0 0 0 2\n"
			+ "2 0 0 0 0 0 0 2\n" + "0 0 0 0 0 0 0 0\n" + "0 0 0 0 0 0 0 0\n" + "0 0 0 0 0 0 0 0";
}
