package ps.백준.S2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_7562_나이트의이동 {
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T,L, nowR, nowC, toR, toC, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2} };// 8방

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			L = Integer.parseInt(input.readLine());
			map = new int[L][L];
			visited = new boolean[L][L];
			
			tokens =new StringTokenizer(input.readLine());
			nowR = Integer.parseInt(tokens.nextToken());
			nowC = Integer.parseInt(tokens.nextToken());
			tokens =new StringTokenizer(input.readLine());
			toR = Integer.parseInt(tokens.nextToken());
			toC = Integer.parseInt(tokens.nextToken());
			cnt = 0;
			bfs(nowR, nowC);
			
//			for (boolean[] row : visited) {
//				System.out.println(Arrays.toString(row));
//			}
			
			System.out.println(--cnt);
		}
		
	}
	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>(); 
		queue.offer(new Point(r,c));
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			while(size-->0) {
			Point p = queue.poll();

				for (int d = 0; d < deltas.length; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					if(isIn(nr,nc) && !visited[nr][nc]) {
						queue.offer(new Point(nr,nc));
						visited[nr][nc] = true;
					}
				}
				if(p.r==toR && p.c ==toC) {
					size = 0;
					queue.clear();
				}
				
			}
			
			cnt++;
		}
	}
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < L && 0 <= c && c < L;
	}

	static String src = "3\r\n" + 
			"8\r\n" + 
			"0 0\r\n" + 
			"7 0\r\n" + 
			"100\r\n" + 
			"0 0\r\n" + 
			"30 50\r\n" + 
			"10\r\n" + 
			"1 1\r\n" + 
			"1 1"
			;
}
