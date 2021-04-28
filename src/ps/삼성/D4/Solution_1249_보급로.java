package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249_보급로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				String line = input.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = line.charAt(c) - '0';
				}
			} // 입력완료

			output.append("#" + t + " " + bfs(0, 0) + "\n");

		}
		System.out.println(output);
	}

	private static int bfs(int i, int j) {
		PriorityQueue<Point2> queue = new PriorityQueue<>();
		queue.offer(new Point2(i, j, 0));
		visited = new boolean[N][N];
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			Point2 p = queue.poll();
			if (p.x == N - 1 && p.y == N - 1)
				return p.cnt;

			for (int d = 0; d < deltas.length; d++) {
				int nr = p.x + deltas[d][0];
				int nc = p.y + deltas[d][1];

				if (!isIn(nr, nc) || visited[nr][nc])
					continue;
				queue.offer(new Point2(nr, nc, p.cnt + map[nr][nc]));
				visited[nr][nc] = true;
			}
		}
		return -1;
	}

//	private static boolean bfs1(int x, int y) {
//		Queue<Point> queue = new LinkedList<>();
//		visited = new boolean[N][N];
//		visited[x][y] = true;
//
//		queue.offer(new Point(x, y));
//
//		while (!queue.isEmpty()) {
//			Point p = queue.poll();
//
//			if (p.x == N - 1 && p.y == N - 1)
//				return true;
//
//			for (int d = 0; d < deltas.length; d++) {
//				int nx = p.x + deltas[d][0];
//				int ny = p.y + deltas[d][1];
//
//				if (!isIn(nx, ny) || visited[nx][ny])
//					continue;
//
//				visited[nx][ny] = true;
//				queue.offer(new Point(nx, ny));
//
//			}
//		}
//		return false;
//	} // 갈수있냐없냐

	private static int bfs2(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[N][N];
		visited[x][y] = true;
		int cnt = 0;
		queue.offer(new Point(x, y));
		int res = 0; // 이동거리

		while (!queue.isEmpty()) {
			int S = queue.size();
			for (int s = 0; s < S; s++) {
				Point p = queue.poll();

				if (p.x == N - 1 && p.y == N - 1)
					return res;

				for (int d = 0; d < deltas.length; d++) {
					int nx = p.x + deltas[d][0];
					int ny = p.y + deltas[d][1];

					if (!isIn(nx, ny) || visited[nx][ny])
						continue;

					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny));
				}

			}
			res++;
		}
		return res;
	} // 최단거리

	private static int bfs3(int x, int y) {
		PriorityQueue<Point2> queue = new PriorityQueue<>();
		visited = new boolean[N][N];
		visited[x][y] = true;

		queue.offer(new Point2(x, y, 0));

		while (!queue.isEmpty()) {
			Point2 p = queue.poll();

			if (p.x == N - 1 && p.y == N - 1)
				return p.cnt;

			for (int d = 0; d < deltas.length; d++) {
				int nx = p.x + deltas[d][0];
				int ny = p.y + deltas[d][1];

				if (!isIn(nx, ny) || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				queue.offer(new Point2(nx, ny, p.cnt + map[nx][ny]));

			}
		}
		return -1;
	} // 갈수있냐없냐

	private static boolean isIn(int nx, int ny) {
		return nx >= 0 && nx < N && ny >= 0 && ny < N;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static class Point2 implements Comparable<Point2> {

		int x, y, cnt;

		public Point2(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override

		public int compareTo(Point2 o) {
			return Integer.compare(cnt, o.cnt); // 오름차순
			// return Integer.compare(o.cnt, cnt); // 내림차순
		}

	}
}
