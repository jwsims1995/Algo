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
	static int R,C, minDust;
	static char[][] map;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken()); 
			if(C==0 && R==0) {
				System.out.println(output);
				System.exit(0);
			}
			minDust = Integer.MAX_VALUE;
			map = new char[R][C];
			int dustCnt = 1;
			Point[] info = new Point[11]; // [0] : 시작점, [1~10] : 먼지 (최대 10개)
			for(int r =0; r<R; r++) {
				String line = input.readLine();
				for(int c=0 ;c<C; c++) {
					map[r][c] = line.charAt(c);
					if(map[r][c] == 'o') info[0] = new Point(r,c);
					else if (map[r][c] =='*') info[dustCnt++] = new Point(r,c);
				}
			}//입력완료
			
			solution(dustCnt, info);
			System.out.println(minDust);
		}
	}
	
	private static void solution(int dustCnt, Point[] info) {
		int[][] distance = new int[dustCnt+1][dustCnt+1];
		for(int i=0; i<dustCnt; i++) { // d[start][end]     start -> end 로 가는 거리 구하기
			for(int j=i+1; j<dustCnt; j++) {
				int dist = bfs(info[i], info[j]);
				if(dist == -1) { // 불가능한 경우
					minDust = -1;
					return;
				}
				distance[i][j] = distance[j][i] = dist;
			}
		}
		for(int[] row : distance) {
			System.out.println(Arrays.toString(row));
		}
		permutation(0, dustCnt-1, 0,new boolean[dustCnt], dustCnt, distance);
		
	}




	private static void permutation(int start, int toChoose, int sum, boolean[] visited, int dustCnt, int[][] distance) {
		if(toChoose == 0) {
			minDust = Math.min(minDust, sum);
			return;
		}
		for(int i=1; i<dustCnt; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permutation(i, toChoose-1, sum+distance[start][i], visited, dustCnt, distance);
				visited[i] = false;
			}
		}
	}

	private static int bfs(Point start, Point end) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		boolean[][] visited = new boolean[R][C];
		visited[start.r][start.c] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point p = queue.poll();
				if(p.r == end.r && p.c == end.c) { //목적지 도달
					return cnt;
				}
				for(int d=0; d<deltas.length; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] != 'x') {
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
