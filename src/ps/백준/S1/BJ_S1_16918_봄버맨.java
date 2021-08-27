package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_16918_봄버맨 {
	static class Bomb {
		int r, c;

		public Bomb(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	static int R, C, N;
	static char[][] map;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Bomb> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'O') {
					queue.add(new Bomb(r, c));
				}
			}
		}
//		for(char[] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
		// N초 후 어케됨?
		int time = N - 1;
		for(int i=1; i<=time; i++) {
//			System.out.println(i+"초 후");
			for (char[] row : map) {
				Arrays.fill(row, 'O'); // 폭탄설치
			}
//			for (char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			i+=1;
			if(i>time)break;
//			System.out.println(i+"초 후");
			boom();
//			for (char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
		}
//		System.out.println("결과");
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				output.append(map[r][c]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	private static void boom() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Bomb p = queue.poll();
				map[p.r][p.c] = '.';
				for (int d = 0; d < deltas.length; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					if (isIn(nr, nc) && map[nr][nc] == 'O') {
						map[nr][nc] = '.';
					}
				}
			}
		}

		findBomb();
	}

	private static void findBomb() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'O') {
					queue.add(new Bomb(r, c));
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static String src = "6 7 5\n" + 
			".......\n" + 
			"...O...\n" + 
			"....O..\n" + 
			".......\n" + 
			"OO.....\n" + 
			"OO.....";

}
