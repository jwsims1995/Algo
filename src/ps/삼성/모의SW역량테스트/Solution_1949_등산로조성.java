package ps.삼성.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static int N, K;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			} // 입력완료
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (max < map[r][c])
						max = map[r][c];
				}
			}
			int ans = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == max)
						ans = Math.max(ans, bfs(r, c));
				}
			}
			System.out.println(ans);
		}
	}

	private static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		int step = 0;
		boolean canUse = true;
		boolean[][] visited= new boolean[N][N];
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			visited[p[0]][p[1]] = true;
			int size = queue.size();
			while (size-- > 0) {
				for (int d = 0; d < deltas.length; d++) {
					int nr = p[0] + deltas[d][0];
					int nc = p[1] + deltas[d][1];
					if (isIn(nr, nc)) {
						if (canUse && map[nr][nc]-K < map[r][c] && map[nr][nc] >= map[r][c] && !visited[nr][nc]) {
							canUse = false;
							queue.offer(new int[] { nr, nc });
						} else if (map[nr][nc] < map[r][c] && !visited[nr][nc]) {
							queue.offer(new int[] { nr, nc });
						}
					}
				}
			}
			step++;
		}
		return step;
	}

	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}

	static String src = "10\r\n" + "5 1\r\n" + "9 3 2 3 2\r\n" + "6 3 1 7 5\r\n" + "3 4 8 9 9\r\n" + "2 3 7 7 7\r\n"
			+ "7 6 5 5 8\r\n" + "3 2\r\n" + "1 2 1\r\n" + "2 1 2\r\n" + "1 2 1\r\n" + "5 2\r\n" + "9 3 2 3 2\r\n"
			+ "6 3 1 7 5\r\n" + "3 4 8 9 9\r\n" + "2 3 7 7 7\r\n" + "7 6 5 5 8\r\n" + "4 4\r\n" + "8 3 9 5\r\n"
			+ "4 6 8 5\r\n" + "8 1 5 1\r\n" + "4 9 5 5\r\n" + "4 1\r\n" + "6 6 1 7\r\n" + "3 6 6 1\r\n" + "2 4 2 4\r\n"
			+ "7 1 3 4\r\n" + "5 5\r\n" + "18 18 1 8 18\r\n" + "17 7 2 7 2\r\n" + "17 8 7 4 3\r\n" + "17 9 6 5 16\r\n"
			+ "18 10 17 13 18\r\n" + "6 4\r\n" + "12 3 12 10 2 2\r\n" + "13 7 13 3 11 6\r\n" + "2 2 6 5 13 9\r\n"
			+ "1 12 5 4 10 5\r\n" + "11 10 12 8 2 6\r\n" + "13 13 7 4 11 7\r\n" + "7 3\r\n" + "16 10 14 14 15 14 14\r\n"
			+ "15 7 12 2 6 4 9\r\n" + "10 4 11 4 6 1 1\r\n" + "16 4 1 1 13 9 14\r\n" + "3 12 16 14 8 13 9\r\n"
			+ "3 4 17 15 12 15 1\r\n" + "6 6 13 6 6 17 12\r\n" + "8 5\r\n" + "2 3 4 5 4 3 2 1\r\n"
			+ "3 4 5 6 5 4 3 2\r\n" + "4 5 6 7 6 5 4 3\r\n" + "5 6 7 8 7 6 5 4\r\n" + "6 7 8 9 8 7 6 5\r\n"
			+ "5 6 7 8 7 6 5 4\r\n" + "4 5 6 7 6 5 4 3\r\n" + "3 4 5 6 5 4 3 2\r\n" + "8 2\r\n"
			+ "5 20 15 11 1 17 10 14\r\n" + "1 1 11 16 1 14 7 5\r\n" + "17 2 3 4 5 13 19 20\r\n"
			+ "6 18 5 16 6 7 8 5\r\n" + "10 4 5 4 9 2 10 16\r\n" + "2 7 16 5 8 9 10 11\r\n"
			+ "12 19 18 8 7 11 15 12\r\n" + "1 20 18 17 16 15 14 13\r\n" + "";
}
