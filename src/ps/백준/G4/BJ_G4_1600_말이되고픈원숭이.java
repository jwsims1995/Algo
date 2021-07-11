package ps.백준.G4;

import java.io.*;
import java.util.*;

public class BJ_G4_1600_말이되고픈원숭이 {
	static class Point {
		int r, c, k;

		public Point(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // bufferdReader로 입력받기
	static StringBuilder output = new StringBuilder(); // stringbuilder를 통해 출력시간 줄이기
	static StringTokenizer tokens; // tokenizer 를 통해 token화를 시키기 위한 준비
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -2 }, { 1, 2 }, { 1, -2 }, { -1, 2 },
			{ 2, 1 }, { 2, -1 }, { -2, -1 }, { -2, 1 }, };
	static int K, C, R, cnt;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src)); // String src를 이용해서 미리
		K = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		// 입력완료
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}

		if (map[0][0] == 1) {
			System.out.println(-1);
			System.exit(0);
		}

		if (bfs(0, 0))
			System.out.println(++cnt);
		else
			System.out.println(-1);
	}

	private static boolean bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[R][C][K + 1];
		queue.add(new Point(r, c, K));
		visited[r][c][K] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Point p = queue.poll();
				//말처럼 가능 + 원숭이 ㄱ
				// 말처럼 가능 + 말로 ㄱ
				// 말 못해서 원숭이 ㄱ
				
				if (p.k > 0) {
					for (int d = 0; d < deltas.length; d++) {
						int nr = p.r + deltas[d][0];
						int nc = p.c + deltas[d][1];
						int k = p.k;
						
						if(d<4) {//원숭이처럼 움직이기
							
						}
						else { //말처럼 움직이기
							k = k-1;
						}
						
						if (d >= 4 && d < deltas.length) { // 말처럼 움직이기

							if (isIn(nr, nc, k) && !visited[nr][nc][k] && map[nr][nc] == 0) {
								queue.add(new Point(nr, nc, k - 1));
								visited[nr][nc][k - 1] = true;

							}
						} else { // 원숭이처럼 움직이기
							visited[nr][nc][k] = true;
							queue.add(new Point(nr, nc, k));
						}
						if (nr == R - 1 && nc == C - 1) {
							return true;
						}

					}
				} else if (p.k == 0) {
					for (int d = 8; d < deltas.length; d++) {
						int nr = p.r + deltas[d][0];
						int nc = p.c + deltas[d][1];
						if (isIn(nr, nc, p.k) && !visited[nr][nc][p.k] && map[nr][nc] == 0) {
							queue.add(new Point(nr, nc, 0));
							visited[nr][nc][p.k] = true;

							if (nr == R - 1 && nc == C - 1) {
								return true;
							}
						}
					}
				}
			}
			cnt++;
		}
		return false;
	}

	private static boolean isIn(int r, int c, int k) {
		return r >= 0 && r < R && c >= 0 && c < C && k >= 0;
	}

	static String src = "1\r\n" + "4 4\r\n" + "0 0 1 1\r\n" + "0 0 1 1\r\n" + "0 0 1 1\r\n" + "1 1 1 0";
}
