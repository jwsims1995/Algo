package ps.백준.S2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_3184_양 {
	static class Animal{
		int s, v, no;

		public Animal(int s, int v, int no) {
			super();
			this.s = s;
			this.v = v;
			this.no = no;
		}
		
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int R,C, no=1, sheep, wolf;
	static char[][] map;
	static int[][] visited;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static List<Animal> list = new ArrayList<>();
	static Animal[] animal;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		visited =new int[R][C];
		
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
		}//입력완료
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}//입력확인
				
		//구역나누기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(visited[r][c] == 0 && map[r][c] != '#') {
					bfs(r,c);
				}
			}
		}
				
		//수 세기
		for (int l = 0; l < list.size(); l++) {
			if(list.get(l).s > list.get(l).v) {
				sheep+=list.get(l).s;
			}else wolf+=list.get(l).v;
		}
		
		//출력
		
		for (int[] row : visited) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.printf("%d %d", sheep, wolf);
		
	}
	private static void bfs(int r, int c) {
		int s = 0;
		int v = 0;
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r,c));
		visited[r][c] = no;
		if(map[r][c] == 'v') {
			v++;
		}
		if(map[r][c] == 'o') {
			s++;
		}
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nr = p.x + deltas[d][0];
				int nc = p.y + deltas[d][1];
				if(isIn(nr,nc) && visited[nr][nc] == 0 && map[nr][nc] != '#') {
					queue.offer(new Point(nr,nc));
					visited[nr][nc] = no;
					if(map[nr][nc] == 'v') {
						v++;
					}
					if(map[nr][nc] == 'o') {
						s++;
					}
				}
			}
		}
		list.add(new Animal(s,v, no));
		no++;
	}
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr < R && 0<=nc && nc < C;
	}
	static String src = "9 12\r\n" + 
			".###.#####..\r\n" + 
			"#.oo#...#v#.\r\n" + 
			"#..o#.#.#.#.\r\n" + 
			"#..##o#...#.\r\n" + 
			"#.#v#o###.#.\r\n" + 
			"#..#v#....#.\r\n" + 
			"#...v#v####.\r\n" + 
			".####.#vv.o#\r\n" + 
			".......####.";
}
