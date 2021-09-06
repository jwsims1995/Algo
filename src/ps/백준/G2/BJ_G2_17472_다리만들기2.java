package ps.백준.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G2_17472_다리만들기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N  = Integer.parseInt(tokens.nextToken());
		int M  = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] =Integer.parseInt(tokens.nextToken()); 
			}
		}//입력완료
		
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}//입력확인
		

		
	}
	static String src = "7 8\r\n" + 
			"0 0 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"1 1 1 1 1 1 1 1";
}
