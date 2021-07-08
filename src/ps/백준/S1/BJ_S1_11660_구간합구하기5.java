package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_11660_구간합구하기5 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N+1][N+1];
		for(int r=1; r<=N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		int[][] Sum = new int[N+1][N+1];
		

		Sum[0][0] = map[0][0];
		
		for (int r = 0; r <= N; r++) {
			int tmpSum = 0;
			for (int c = 0; c <= N; c++) {
				tmpSum+= map[r][c];
				Sum[r][c] += tmpSum;
			}
		}
		
//		for(int[] row:Sum) {
//			System.out.println(Arrays.toString(row));
//		}
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			
			int sum = 0;
			for (int r = x1; r <= x2; r++) {
				sum += (Sum[r][y2] - Sum[r][y1-1]);
			}
			output.append(sum).append("\n");
		}
		System.out.println(output);
	}
	static String src = "2 4\n" + 
			"1 2\n" + 
			"3 4\n" + 
			"1 1 1 1\n" + 
			"1 2 1 2\n" + 
			"2 1 2 1\n" + 
			"2 2 2 2";
}
