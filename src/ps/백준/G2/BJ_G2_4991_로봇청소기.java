package ps.백준.G2;

import java.io.*;
import java.util.*;

public class BJ_G2_4991_로봇청소기 {
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		

	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C, robotR, robotC, dust, cnt, ans;
	static char[][] map;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		while(true) {
			cnt = 0;
			dust = 0;
			tokens = new StringTokenizer(input.readLine());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken()); 
			if(C==0 && R==0) {
				System.out.println(output);
				return;
			};
			map = new char[R][C];
			int idx = 1;
			Point[] info = new Point[11];
			for(int r =0; r<R; r++) {
				String line = input.readLine();
				for(int c=0 ;c<C; c++) {
					map[r][c] = line.charAt(c);
					if(map[r][c] == 'o') info[0] = new Point(r,c);
					else if (map[r][c] =='*') info[idx++] = new Point(r,c);
				}
			}//입력완료
			
			//순열 구하기
//			np(3, new Point[3], 0, info);
			permutation(3, new Point[3] , new boolean[3] ,info);
			//최솟값 찾기
			
			System.out.println(ans);
			if(ans == -1 ) return;
		}

	}
	
	private static void permutation(int toChoose, Point[] choosed, boolean[] visited, Point[] info) {
		if(toChoose == 0) {
			int size = info.length;
			cnt = 0;
			for(int s=1; s<size; s++) {
				int count = bfs(s, info);
				if(count == -1) {
					ans = -1;
					return;
				}
				cnt += count;
			}
			ans = Math.min(ans, cnt);
			return;
		}
		for(int i=1; i<info.length; i++) {
			visited[i] = true;
			choosed[choosed.length-toChoose] = info[i];
			permutation(toChoose-1, choosed, visited, info);
			visited[i] = false;
		}
	}



	private static int bfs(int idx, Point[] info) {
		Queue<Point> queue = new LinkedList<>();
		Point start = info[idx-1];
		System.out.println(start);
		int toR = info[idx].r;
		int toC = info[idx].c;
		int cnt =0;
		queue.add(start);
		boolean[][] visited = new boolean[R][C];
		visited[start.r][start.c]= true;
		while(!queue.isEmpty()) {
			int size=  queue.size();
			while(size-->0) {
				Point p = queue.poll();
				if(p.r == toR && p.c == toC) {
					
					return cnt;
				}
				for(int d=0; d<deltas.length; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					if(isIn(nr,nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new Point(nr,nc));
					}
				}
			}
			cnt++;
		}
		return -1;
	}



	private static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C ;
	}

	static String src = "7 5\r\n" + 
			".......\r\n" + 
			".o...*.\r\n" + 
			".......\r\n" + 
			".*...*.\r\n" + 
			".......\r\n" + 
			"15 13\r\n" + 
			".......x.......\r\n" + 
			"...o...x....*..\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			"...............\r\n" + 
			"xxxxx.....xxxxx\r\n" + 
			"...............\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			"..*....x....*..\r\n" + 
			".......x.......\r\n" + 
			"10 10\r\n" + 
			"..........\r\n" + 
			"..o.......\r\n" + 
			"..........\r\n" + 
			"..........\r\n" + 
			"..........\r\n" + 
			".....xxxxx\r\n" + 
			".....x....\r\n" + 
			".....x.*..\r\n" + 
			".....x....\r\n" + 
			".....x....\r\n" + 
			"0 0";
}
