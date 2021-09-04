package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_15724_주지수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C;
	static int[][] map;
	static int[][] sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		sum = new int[R][C];
		for(int r=0;r<R;r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0;c<C;c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
//		for(int[] row: map) {
//			System.out.println(Arrays.toString(row));
//		}
		//구간합구하기
		for(int r=0; r<R;r++) {
			for(int c=0;c<C;c++) {
				if(c==0) {
					sum[r][c] = map[r][c];
				}else {
					sum[r][c] = sum[r][c-1] + map[r][c];					
				}
			}
		}
//		System.out.println();
//		for(int[] row: sum) {
//			System.out.println(Arrays.toString(row));
//		}
		int tc= Integer.parseInt(input.readLine());
		while(tc-->0) {
			int ans = 0;
			tokens = new StringTokenizer(input.readLine());
			int startR = Integer.parseInt(tokens.nextToken())-1;
			int startC = Integer.parseInt(tokens.nextToken())-1;
			int endR = Integer.parseInt(tokens.nextToken())-1;
			int endC = Integer.parseInt(tokens.nextToken())-1;
			
			
			for(int r=startR; r<=endR; r++) {
				if(startC==0) {
					ans +=sum[r][endC];
					continue;
				}
				ans+= sum[r][endC]-sum[r][startC-1];
			}
			output.append(ans).append("\n");
		}
		System.out.println(output);
			
		
	}
	static String src = "4 4\n" + 
			"9 14 29 7\n" + 
			"1 31 6 13\n" + 
			"21 26 40 16\n" + 
			"8 38 11 23\n" + 
			"3\n" + 
			"1 1 3 2\n" + 
			"1 1 1 4\n" + 
			"2 2 4 4";
}
