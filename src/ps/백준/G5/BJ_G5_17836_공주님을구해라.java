package ps.백준.G5;

import java.io.*;
import java.util.*;

public class BJ_G5_17836_공주님을구해라 {
	static class Point {
		int r, c, item, time;

		public Point(int r, int c, int item, int time) {
			this.r = r;
			this.c = c;
			this.item = item;
			this.time = time;
		}
	}

	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, T, cnt;
	static int[][] map;
	static Queue<Point> queue;
	static boolean[][][] visited;
	static boolean isFound;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력완료
//		for(int[] row:map) {
//			System.out.println(Arrays.toString(row));
//		}

		bfs();

		System.out.println(isFound && cnt <= T ? cnt : "Fail");
//		System.out.println(cnt);
	}

	private static void bfs() {
		queue = new LinkedList<>();
		visited = new boolean[N][M][2];
		queue.offer(new Point(0, 0, 0, 0));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.r == N - 1 && p.c == M - 1) {
				cnt = p.time;
				isFound = true;
				return;
			}

			int dlen = deltas.length;
			for (int d = 0; d < dlen; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				int nt = p.time + 1;
				int ni = p.item;
				if (ni == 0) {// 그람이 없을때
					if (isIn(nr, nc) && !visited[nr][nc][ni] && map[nr][nc] != 1) { 
						if (map[nr][nc] == 0) {
							queue.offer(new Point(nr, nc, ni, nt));
							visited[nr][nc][ni] = true;
						}

						else if (map[nr][nc] == 2) {
							queue.offer(new Point(nr, nc, ni+1, nt));
							visited[nr][nc][ni+1] = true;
						}
					}
				} else { // 그람을 얻었을때
					if (isIn(nr, nc) && !visited[nr][nc][ni]) {
						queue.offer(new Point(nr, nc, ni, nt));
						visited[nr][nc][ni] = true;
					}
				}

			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

	private static String src = "3 4 6\n" + 
			"0 1 0 1\n" + 
			"0 0 0 1\n" + 
			"0 0 1 0";
}
