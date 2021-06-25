package ps.백준.S2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_3187_양치기꿍 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C , sheep, wolf;
	static int[][] deltas = {{0,-1},{0,1},{1,0},{-1,0}};
	static boolean[][] visited;
	static char[][] map;
	
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
		}//입력완료
		
		//bfs시작
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] != '#' && !visited[r][c]) bfs(r,c);
			}
		}
		
		System.out.print(sheep + " " + wolf);
	}
	private static void bfs(int r, int c) {
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r,c));
		visited[r][c] = true;
		int s=0;
		int w=0;

		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(map[p.x][p.y] == 'k') s++;
			if(map[p.x][p.y] == 'v') w++;
			for (int d = 0; d < deltas.length; d++) {
				int nr = p.x + deltas[d][0];
				int nc = p.y + deltas[d][1];
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] != '#') {
					queue.add(new Point(nr,nc));
					visited[nr][nc] = true;

				}
			}
		}
		if(s > w) sheep+=s;
		else wolf+=w;
	}
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr < R && 0<=nc && nc < C;
	}
	static String src = "9 12\r\n" + 
			".###.#####..\r\n" + 
			"#.kk#...#v#.\r\n" + 
			"#..k#.#.#.#.\r\n" + 
			"#..##k#...#.\r\n" + 
			"#.#v#k###.#.\r\n" + 
			"#..#v#....#.\r\n" + 
			"#...v#v####.\r\n" + 
			".####.#vv.k#\r\n" + 
			".......####.";
}
