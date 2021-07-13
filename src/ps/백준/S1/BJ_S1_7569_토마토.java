package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_7569_토마토 {
	static class Point {
		int r, c, h;

		public Point(int h, int r, int c) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int M, N, H, cnt, num;
	static int[][][] map;
	static boolean[][][] visited;
	static int[][] deltas = { { 0, 0, 1 }, { 0, 0, -1 }, { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 } };
	static List<Integer> list = new ArrayList<>();
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		map = new int[H][N][M];
		visited = new boolean[H][N][M];

		queue = new LinkedList<>();

		boolean canDo = false;

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < M; c++) {
					map[h][r][c] = Integer.parseInt(tokens.nextToken());
					if (map[h][r][c] == 0)
						canDo = true;
				}
			}
		}

		if (!canDo) {
			System.out.println(0);
			System.exit(0);
		}
//		// 출력
//		for (int[][] col : map) {
//			for (int[] row : col) {
//				System.out.println(Arrays.toString(row));
//			}
//		}

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visited[h][r][c] && map[h][r][c] == 1) {
						queue.add(new Point(h, r, c));
						visited[h][r][c] = true;
					}
				}
			}
		}

		bfs();

		if (!allGood()) {
			System.out.println(-1);

		} else {
			System.out.println(--cnt);
		}
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Point p = queue.poll();
				
				for (int d = 0; d < deltas.length; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					int nh = p.h + deltas[d][2];
					if (isIn(nr, nc, nh) && !visited[nh][nr][nc] && map[nh][nr][nc] == 0) {
						queue.add(new Point(nh, nr, nc));
						map[nh][nr][nc] = 1;
						visited[nh][nr][nc] = true;

					}
				}
			}
			cnt++;
		}

	}

	private static boolean allGood() {
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[h][r][c] == 0)
						return false;
				}
			}
		}
		return true;
	}

	private static boolean isIn(int r, int c, int h) {
		return r >= 0 && r < N && c >= 0 && c < M && h >= 0 && h < H;
	}

	static String src = "5 3 2\n" + "0 0 0 0 0\n" + "0 0 0 0 0\n" + "0 0 0 0 0\n" + "0 0 0 0 0\n" + "0 0 1 0 0\n"
			+ "0 0 0 0 0";

}
