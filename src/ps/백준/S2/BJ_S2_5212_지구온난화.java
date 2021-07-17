package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_5212_지구온난화 {
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
	static int R, C;
	static char[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R + 2][C + 2];
		visited= new boolean[R+2][C+2];
		for (int r = 0; r < R + 2; r++) {
			Arrays.fill(map[r], '.');
		}

		for (int r = 1; r <= R; r++) {
			String line = input.readLine();
			for (int c = 1; c <= C; c++) {
				map[r][c] = line.charAt(c - 1);
			}
		}
		// 입력완료

		for (char[] row : map) {
			System.out.println(row);
		} // 입력확인

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (map[r][c] == 'X')
					bfs(r, c);
			}
		}
		
		
		System.out.println();
		for (char[] row : map) {
			System.out.println(row);
		} // 입력확인
		
		System.out.println();
		
		int startR = 10;
		int endR = 0;
		int startC = 10;
		int endC = 0;
		
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (map[r][c] == 'X') {
					startR = Math.min(startR, r);
					endR = Math.max(endR, r);
					startC = Math.min(startC, c);
					endC = Math.max(endC, c);
				}
					
			}
		}
		
		System.out.println(startR);
		System.out.println(endR);
		System.out.println(startC);
		System.out.println(endC);
		
		for (int r = startR; r <= endR; r++) {
			for (int c = startC; c <= endC; c++) {
				output.append(map[r][c]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	
	private static void bfs(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(!visited[nr][nc] && map[nr][nc] == '.') {
				cnt++;
			}
		}
		if(cnt >= 3) {
			visited[r][c] = true;
			map[r][c] = '.';
		}

	}

	static String src = "3 10\n" + 
			"..........\n" + 
			"..XXX.XXX.\n" + 
			"XXX.......";
}
