package ps.백준.G5;

import java.io.*;
import java.util.*;

public class BJ_G5_10026_적록색약 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	
	static char[][] map;

	static Queue<Point> queue = new LinkedList<>();
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			String line = input.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		//bfs한번

		int rgb = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					bfs(r,c);
					rgb++;
				}
			}
		}

		int rb = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 'G') map[r][c] = 'R';
			}
		}
		queue = new LinkedList<>();
		visited= new boolean[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					bfs(r,c);
					rb++;
				}
			}
		}
		
		System.out.printf("%d %d", rgb, rb);
	}

	private static void bfs(int r, int c) {
		queue.offer(new Point(r,c));
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int dLen = deltas.length;
			for (int d = 0; d < dLen; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				if(isIn(nr,nc) && !visited[nr][nc] && map[p.r][p.c] == map[nr][nc]) {
					queue.offer(new Point(nr,nc));
					visited[nr][nc] = true;
				}
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N ;
	}

	private static String src = "5\n" + 
			"RRRBB\n" + 
			"GGBBB\n" + 
			"BBBRR\n" + 
			"BBRRR\n" + 
			"RRRRR";
}
