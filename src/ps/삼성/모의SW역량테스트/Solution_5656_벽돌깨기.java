package ps.삼성.모의SW역량테스트;

import java.io.*;
import java.util.*;

public class Solution_5656_벽돌깨기 {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N, C, R, min;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			int[][] map = new int[R][C];
			for (int r = 0; r < R; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			} // 입력
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			} // 입력확인
//			System.out.println();
			min = Integer.MAX_VALUE;
			sol(N, map);

			output.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(output);
	}

	static void sol(int cnt, int[][] map) {
		int result = getRemain(map);
		if (result == 0) {
			min = 0;
			return;
		}

		if (cnt == 0) {
			min = Math.min(min, result);
			return;
		}

		int[][] copyMap = new int[R][C];
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				if (map[r][c] > 0) {
					copyMap(map, copyMap);
					boom(r, c, copyMap);
					down(copyMap);
					sol(cnt - 1, copyMap);
					break;
				}
			}
		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					++count;
			}
		}
		return count;
	}

	static void down(int[][] map) {
		List<Integer> list = new ArrayList<>();
		for (int c = 0; c < C; c++) {
			for (int r = R - 1; r >= 0; r--) {
				if (map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				map[R - i - 1][c] = list.get(i);
			}
			list.clear();
		}
	}

	static void boom(int r, int c, int[][] map) {
		Queue<Point> queue = new LinkedList<>();
		if (map[r][c] > 1) {
			queue.add(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			int cnt = p.cnt;

			for (int d = 0; d < deltas.length; d++) {
				for (int i = 1; i < cnt; i++) {
					int nr = p.r + deltas[d][0] * i;
					int nc = p.c + deltas[d][1] * i;
					if (isIn(nr, nc) && map[nr][nc] > 0) {
						queue.add(new Point(nr, nc, map[nr][nc]));
						map[nr][nc] = 0;
					}
				}
			}

		}
	}

	static void copyMap(int[][] map, int[][] copyMap) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copyMap[r][c] = map[r][c];
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

	static String src = "5\r\n" + "3 10 10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "1 0 1 0 1 0 0 0 0 0\r\n"
			+ "1 0 3 0 1 1 0 0 0 1\r\n" + "1 1 1 0 1 2 0 0 0 9\r\n" + "1 1 4 0 1 1 0 0 1 1\r\n"
			+ "1 1 4 1 1 1 2 1 1 1\r\n" + "1 1 5 1 1 1 1 2 1 1\r\n" + "1 1 6 1 1 1 1 1 2 1\r\n"
			+ "1 1 1 1 1 1 1 1 1 5\r\n" + "1 1 7 1 1 1 1 1 1 1\r\n" + "2 9 10\r\n" + "0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "1 1 0 0 1 0 0 0 0\r\n"
			+ "1 1 0 1 1 1 0 1 0\r\n" + "1 1 0 1 1 1 0 1 0\r\n" + "1 1 1 1 1 1 1 1 0\r\n" + "1 1 3 1 6 1 1 1 1\r\n"
			+ "1 1 1 1 1 1 1 1 1\r\n" + "3 6 7\r\n" + "1 1 0 0 0 0\r\n" + "1 1 0 0 1 0\r\n" + "1 1 0 0 4 0\r\n"
			+ "4 1 0 0 1 0\r\n" + "1 5 1 0 1 6\r\n" + "1 2 8 1 1 6\r\n" + "1 1 1 9 2 1\r\n" + "4 4 15\r\n"
			+ "0 0 0 0 \r\n" + "0 0 0 0 \r\n" + "0 0 0 0 \r\n" + "1 0 0 0 \r\n" + "1 0 0 0 \r\n" + "1 0 0 0 \r\n"
			+ "1 0 0 0 \r\n" + "1 0 5 0 \r\n" + "1 1 1 0 \r\n" + "1 1 1 9 \r\n" + "1 1 1 1 \r\n" + "1 6 1 2 \r\n"
			+ "1 1 1 5 \r\n" + "1 1 1 1 \r\n" + "2 1 1 2 \r\n" + "4 12 15\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9";
}
