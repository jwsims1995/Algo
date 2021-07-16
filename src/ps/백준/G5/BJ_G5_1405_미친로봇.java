package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1405_미친로봇 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static double result;
	static int[][] deltas = {{0,1},{0,-1},{-1,0},{1,0}}; //동서남북
	static int[] percent = new int[4];
	static boolean[][] visited = new boolean[30][30];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		for(int i=0; i<4; i++){
			percent[i] = Integer.parseInt(tokens.nextToken());
		}
		
		visited[15][15] = true;
		permutation(15, 15, N, 1.0);
		 

		System.out.println(String.format("%.2f", result));
		System.out.println(Math.round(result * 100) / 100.0);
	}


	private static void permutation(int r, int c, int toChoose, double total) {
		if(toChoose == 0) {
			result+=total;
//			System.out.println(result);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				
				permutation(nr, nc, toChoose-1, total * percent[d] * 0.01);
				visited[nr][nc] = false;
			}
		}
	}

	private static String src = "2 25 25 25 25";
}
