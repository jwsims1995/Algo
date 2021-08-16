package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_18111_마인크래프트 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, B, ans;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C= Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}//입력완료
		for(int[] row : map) {
			System.out.println(Arrays.toString(row));
		}//입력확인
		
		 
		
	}
	static String src = "3 4 99\n" + 
			"0 0 0 0\n" + 
			"0 0 0 0\n" + 
			"0 0 0 1";
}