package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17144_미세먼지안녕 {
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c =c;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C,T, ans; // 입력

	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		for(int r=0; r<R;r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}//입력완료
		for(int[] row: map) {
			System.out.println(Arrays.toString(row));
		}//입력확인
		
		//미세먼지 확산 
		Queue<Point> queue =new LinkedList<>();
		for(int t=0; t<T; t++) {
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(map[r][c] > 0) {
						queue.add(new Point(r,c));
					}
				}
			}
			spread(queue);
		}

		
		
		System.out.println();
		for(int[] row: map) {
			System.out.println(Arrays.toString(row));
		}//입력확인
		
		
		// 공기청정기 이동
	}

	private static void spread(Queue<Point> queue) {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r=  p.r;
			int c = p.c;
			int dust = map[r][c] / 5;
			for(int d=0; d<deltas.length;d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				if(isIn(nr,nc) && map[r][c] >= map[nr][nc] + dust && map[nr][nc] != -1) {
					map[nr][nc] += dust;
					map[r][c] -=dust;
				}
			}
		}

	}

	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}

	static String src = "7 8 1\n" + 
			"0 0 0 0 0 0 0 9\n" + 
			"0 0 0 0 3 0 0 8\n" + 
			"-1 0 5 0 0 0 22 0\n" + 
			"-1 8 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 10 43 0\n" + 
			"0 0 5 0 15 0 0 0\n" + 
			"0 0 40 0 0 0 20 0";
}
