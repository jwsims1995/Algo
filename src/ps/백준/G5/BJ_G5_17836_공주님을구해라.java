package ps.백준.G5;

import java.io.*;
import java.util.*;

public class BJ_G5_17836_공주님을구해라 {
	static class Point{
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
	static int N, M, T, cnt;
	static int[][] map;
	static Queue<Point> queue;
	static boolean[][] visited;
	static boolean hasGram, isFound;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens =new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}//입력완료
//		for(int[] row:map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		bfs(0,0);
		
		System.out.println(--cnt<=T && isFound?cnt:"Fail");
//		System.out.println(cnt);

	}

	private static void bfs(int r, int c) {
		queue = new LinkedList<>();
		visited = new boolean[N][M];
		queue.offer(new Point(r,c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int size=  queue.size();
			boolean tmp = false;
			while(size-->0) {
				Point p = queue.poll();
				if(p.r==N-1 && p.c == M-1 ) {
					isFound = true;
					cnt++;
					return;
				}
				
				int dlen = deltas.length;
				for (int d = 0; d < dlen; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					

					
					
					if(isIn(nr,nc) && !hasGram &&!visited[nr][nc] && map[nr][nc] != 1) { // 그람이 없을때
						queue.offer(new Point(nr,nc));
						visited[nr][nc] =true;
						
						if(map[nr][nc] == 2) {//그람위치부터 시작
							queue.offer(new Point(nr,nc));
							tmp = true;
						}
					}
					
					else if(isIn(nr,nc) && hasGram &&!visited[nr][nc]) { //그람을 얻었을때
						queue.offer(new Point(nr,nc));
						visited[nr][nc] =true;
					}
				}
			}
			if(tmp) hasGram = true;
			cnt++;
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N ;
	}

	private static String src = "4 4 8\n" + 
			"0 1 0 2\n" + 
			"0 0 0 1\n" +
			"1 1 1 0\n" +
			"0 0 0 0";
}
