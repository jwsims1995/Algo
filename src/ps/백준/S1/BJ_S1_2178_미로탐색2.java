package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2178_미로탐색2 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String line = input.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		bfs(0, 0);
		System.out.println(map[N - 1][M - 1]);
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		boolean[][] visited = new boolean[N][M];
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			visited[p.r][p.c] = true;
			for (int d = 0; d < deltas.length; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
					map[nr][nc] = map[p.r][p.c] + 1;
				}
			}

		}
	}

	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}

	static String src = "4 6\r\n" + "110110\r\n" + "110110\r\n" + "111111\r\n" + "111101";

}
