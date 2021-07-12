package ps.백준.G5;

import java.io.*;
import java.util.*;
public class BJ_G5_2636_치즈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,cnt;
	static int[][] map;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}//입력완료
		
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}//입력확인
		
		cnt = 1;
		
		
		
		
	}

	private static boolean isIn(int r, int c) {
	}

	static String src = "13 12\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";
}

