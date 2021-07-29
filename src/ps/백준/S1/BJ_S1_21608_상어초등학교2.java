package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_21608_상어초등학교2 {
	static class Student {
		int r, c;

		public Student(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, num, R, C;
	static int[][] map;
	static int[][] student;
	static boolean[][] visited;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Student> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N + 1][N + 1];
		student = new int[N * N + 1][5];
		visited = new boolean[N + 1][N + 1];
		for (int n = 1; n <= N * N; n++) {
			tokens = new StringTokenizer(input.readLine());
			student[n][0] = Integer.parseInt(tokens.nextToken()); // 번호

			student[n][1] = Integer.parseInt(tokens.nextToken());
			student[n][2] = Integer.parseInt(tokens.nextToken());
			student[n][3] = Integer.parseInt(tokens.nextToken());
			student[n][4] = Integer.parseInt(tokens.nextToken());
		}

		for (int n = 1; n <= N * N; n++) {
			int num = student[n][0];
			if (n == 1) {
				map[(N + 1) / 2][(N + 1) / 2] = num;
				visited[(N + 1) / 2][(N + 1) / 2] = true;
				continue;
			}
			sol1(num);
			if (queue.size() == 1) {
				Student p = queue.poll();
				map[p.r][p.c] = num;
				visited[p.r][p.c] = true;
				continue;
			}
			sol2(num);
			map[R][C] = num;
		}

		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
	}

	static void sol2(int n) {// 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
		int max = 0;
		while (!queue.isEmpty()) {
			Student p = queue.poll();
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				if (isIn(nr, nc) && map[nr][nc] == 0) {
					cnt++;
				}
			}
			if (max < cnt) {
				R = p.r;
				C = p.c;
				max = cnt;
			}
		}
	}

	static void sol1(int n) {// 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];

					if (isIn(nr, nc) && !visited[nr][nc]
							&& (map[nr][nc] == student[n][1] || map[nr][nc] == student[n][2]
									|| map[nr][nc] == student[n][3] || map[nr][nc] == student[n][4])) {
						queue.offer(new Student(nr, nc));
						visited[nr][nc] =  true;
					}
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return 1 <= r && r <= N && 1 <= c && c <= N;
	}

	static String src = "3\r\n" + "4 2 5 1 7\r\n" + "3 1 9 4 5\r\n" + "9 8 1 2 3\r\n" + "8 1 9 3 4\r\n"
			+ "7 2 3 4 8\r\n" + "1 9 2 5 7\r\n" + "6 5 2 3 4\r\n" + "5 1 9 2 8\r\n" + "2 9 3 1 4";
}
