package ps.삼성.D4;

import java.io.*;
import java.util.*;

public class Solution_1861_정사각형방 {
	static class Point{
		int r, c;
		public Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int T, N;
	static int[][] map;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int deltas[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}//입력완료
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cnt = bfs(r,c);
					
					if(cnt > max) {
						max = cnt;
						min = map[r][c];
					}else if(cnt == max) {
						min = Math.min(min, map[r][c]);
					}
					
				}
			}
			
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			output.append("#").append(t).append(" ").append(min).append(" ").append(max).append("\n");
		}
		System.out.println(output);
	}
	private static int bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r,c));
		int cnt =0 ;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point p = queue.poll();
				for (int d = 0; d < deltas.length; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					if(isIn(nr,nc) && map[p.r][p.c] + 1 == map[nr][nc]) {
						queue.add(new Point(nr,nc));
					}
				}
			}
			cnt++;
		}
		return cnt;
	}
	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
	static String src ="2\n" + 
			"8\n" + 
			"38 39 40 41 42 43 44 45 \n" + 
			"46 47 48 49 50 51 52 53 \n" + 
			"54 55 56 57 58 59 60 61 \n" + 
			"62 63 64 1 2 3 4 5 \n" + 
			"6 7 8 9 10 11 12 13 \n" + 
			"14 15 16 17 18 19 20 21 \n" + 
			"22 23 24 25 26 27 28 29 \n" + 
			"30 31 32 33 34 35 36 37 \n" + 
			"4\n" + 
			"13 2 14 12 \n" + 
			"10 16 6 5 \n" + 
			"1 8 3 15 \n" + 
			"7 11 4 9 \n";
}
