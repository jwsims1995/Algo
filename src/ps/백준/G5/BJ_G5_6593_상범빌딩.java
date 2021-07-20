package ps.백준.G5;

import java.io.*;
import java.util.*;

public class BJ_G5_6593_상범빌딩 {
	static class Point{
		int l, r, c;
		public Point(int l, int r, int c) {
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][] deltas = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
	static boolean[][][] visited;
	static char[][][] map;
	static int L, R, C, cnt;
	static Point start;
	static boolean canGo;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		while(true) {
			
			tokens =new StringTokenizer(input.readLine());
			L = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			
			if(L==0 && R == 0 && C ==0) System.exit(0);
			
			map = new char[L+1][R+1][C+1];
			for (int l = 1; l <= L; l++) {
				for (int r = 1; r <= R; r++) {
					String line = input.readLine();
					for (int c = 1; c <= C; c++) {
						map[l][r][c] = line.charAt(c-1);
						if(map[l][r][c] == 'S') {
							start= new Point(l, r, c);
						}
					}
				}
				input.readLine();
			}//입력완료
			
//		for (char[][] chars : map) {
//			for (char[] row : chars) {
//				System.out.println(Arrays.toString(row));
//			}
//		}//입력확인
			
			
			cnt =0 ;
			canGo = false;
			bfs(start);
			System.out.println(canGo?"Escaped in "+ ++cnt + " minute(s).":"Trapped!");
			
		}
	}
	private static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[L+1][R+1][C+1];
		queue.add(start);
		visited[start.l][start.r][start.c] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point p = queue.poll();
				int deltaSize = deltas.length;
				for (int i = 0; i < deltaSize ; i++) {
					int nl = p.l + deltas[i][0];
					int nr = p.r + deltas[i][1];
					int nc = p.c + deltas[i][2];
					if(isIn(nl, nr, nc) && !visited[nl][nr][nc] && map[nl][nr][nc] != '#') {						
						visited[nl][nr][nc]= true;
						queue.add(new Point(nl,nr,nc));
						
						if(map[nl][nr][nc] == 'E') {
							canGo = true;
							return; // 구멍발견
						}
					}
				}
			}
			cnt++;
		}
	}
	private static boolean isIn(int nl, int nr, int nc) {
		return nl>=1 && nl<=L && nr>=1 && nr<=R && nc>=1 && nc<=C;
	}
	static String src = "3 4 5\r\n" + 
			"S....\r\n" + 
			".###.\r\n" + 
			".##..\r\n" + 
			"###.#\r\n" + 
			"\r\n" + 
			"#####\r\n" + 
			"#####\r\n" + 
			"##.##\r\n" + 
			"##...\r\n" + 
			"\r\n" + 
			"#####\r\n" + 
			"#####\r\n" + 
			"#.###\r\n" + 
			"####E\r\n" + 
			"\r\n" + 
			"1 3 3\r\n" + 
			"S##\r\n" + 
			"#E#\r\n" + 
			"###\r\n" + 
			"\r\n" + 
			"0 0 0";
}

