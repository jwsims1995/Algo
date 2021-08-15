package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_14500_테트리미노 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer output = new StringBuffer();
	static StringTokenizer tokens;
	static int R, C, max;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int r=0; r<R;r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}//입력
		for(int[] row : map) {
			System.out.println(Arrays.toString(row));
		}//입력확인
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				visited[r][c] = true;
				check(r,c,1, map[r][c]);
				max = Math.max(max, findMiddle(r,c));
				visited[r][c] = false;
			}
		}
		System.out.println(max);
		 
	}

	private static int findMiddle(int r, int c) {
		int cnt = 0;
		int sum = map[r][c];
		int min = Integer.MAX_VALUE;
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc)) {
				cnt++;
				sum+=map[nr][nc];
				min = Math.min(min, map[nr][nc]);
			}
		}
		if(cnt == 4) {
			return sum-min;
		}else if(cnt == 3) {
			return sum;
		}else {
			return -1;
		}
	}
 
	private static void check(int r, int c, int step, int sum) {
		if(step == 4) {
			max = Math.max(max, sum);
			return;
		}
		for(int d=0; d<deltas.length; d++) {
			int nr= r + deltas[d][0];
			int nc= c + deltas[d][1];
			if(isIn(nr,nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				check(nr, nc, step+1, sum+map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr>= 0 && nr< R && nc >= 0 && nc < C;
	}

	static class Point{
		int r,c,step;
		public Point(int r, int c, int step){
			this.r =  r;
			this.c = c;
			this.step = step;
		}
	}
	static String src = "5 5\n" + 
			"1 2 3 4 5\n" + 
			"5 4 3 2 1\n" + 
			"2 3 4 5 6\n" + 
			"6 5 4 3 2\n" + 
			"1 2 1 2 1";
}
