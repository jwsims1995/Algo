package ps.백준.G2;

import java.io.*;
import java.util.*;

public class BJ_G2_13460_구슬탈출2 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, cnt;
	static char[][] map;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static Point hole, blue, red;
	static boolean[][] visited = new boolean[11][11];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
			for (int c = 1; c < C - 1; c++) {
				if (map[r][c] == 'O') {
					hole = new Point(r, c);
				} // 구멍 찾기
				else if(map[r][c] == 'R') red = new Point(r,c);
			}
		}
		for (int r = 0; r < R; r++) {
			System.out.println(Arrays.toString(map[r]));
		} // 입력확인
		
		bfs();

	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

	static String src = "5 5\r\n" + "#####\r\n" + "#..B#\r\n" + "#.#.#\r\n" + "#RO.#\r\n" + "#####";
}
