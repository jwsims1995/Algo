package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_21608_상어초등학교 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[][] like;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		like = new int[N*N+1][5];
		map = new int[N*N+1][N*N+1];
		for (int i = 0; i < N*N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			for (int j = 1; j < 5; j++) {
				like[a][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		//입력완료
		for (int[] row : like) {
			System.out.println(Arrays.toString(row));
		}
	}
	static String src = "3\r\n" + 
			"4 2 5 1 7\r\n" + 
			"3 1 9 4 5\r\n" + 
			"9 8 1 2 3\r\n" + 
			"8 1 9 3 4\r\n" + 
			"7 2 3 4 8\r\n" + 
			"1 9 2 5 7\r\n" + 
			"6 5 2 3 4\r\n" + 
			"5 1 9 2 8\r\n" + 
			"2 9 3 1 4";
}
