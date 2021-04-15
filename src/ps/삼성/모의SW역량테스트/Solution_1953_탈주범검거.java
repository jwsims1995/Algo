package ps.삼성.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int N, M, R, C, L, map[][];
	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } }; // 상 0 , 좌 1, 우 2, 하 3
	static String[] type = { null, "0312", // 1: 상하좌우
			"03", // 2: 상하
			"12", // 3: 좌우
			"02", // 4: 상우
			"32", // 5: 하우
			"31", // 6: 하
			"01" // 7: 상좌
	};

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			L = Integer.parseInt(tokens.nextToken());
			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			System.out.println("#" + t + " " + bfs());
		}
	}

	private static int bfs() {
		int result = 0, time = 1;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		queue.offer(new int[] { R, C });
		visited[R][C] = true;
		++result;
		while (time++ < L) {
			int size = queue.size();
			while (size-- > 0) { // 동시간대 처리
				int[] current = queue.poll();
				int r = current[0];
				int c = current[1];
				String info = type[map[r][c]]; // 현 구조물의 타입으로 이동가능한 방향의 정보

				for (int d = 0, length = info.length(); d < deltas.length; d++) {
					int dir = info.charAt(d) - '0';
					int nr = r + deltas[dir][0];
					int nc = c + deltas[dir][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] > 0
							&& type[map[nr][nc]].contains(Integer.toString(3 - dir)) && !visited[nr][nc]) {
						queue.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
						++result;
					} 
				}
			}

		}

		return result;
	}

}
