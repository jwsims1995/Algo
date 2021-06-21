package ps.백준.B1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_B1_1592_영식이와친구들2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C;
	static char[][] map;
	static int[][] deltas=  {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 'W')bfs(r,c);
			}
		}
		
		for (char[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		
	}
	static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(r,c));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nr = p.x + deltas[d][0];
				int nc = p.y + deltas[d][1];
				if(isIn(nr,nc) && map[nr][nc] == '.') {
					queue.add(new Point(nr,nc));
				}
				if(isIn(nr,nc) && map[nr][nc] == 'S' && map[p.x][p.y]=='.') {
					map[p.x][p.y] = 'D';
				}
			}
			
		}
	}
	private static boolean isIn(int r, int c) {
		return 0<=r && r<R && 0<=c && c<C;
	}
	
	static String src = "6 6\r\n" + 
			"..S...\r\n" + 
			"..S.W.\r\n" + 
			".S....\r\n" + 
			"..W...\r\n" + 
			"...W..\r\n" + 
			"......";
}
