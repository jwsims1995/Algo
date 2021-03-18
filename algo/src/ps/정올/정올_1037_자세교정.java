package ps.정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_1037_자세교정 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, ar, ac;
	static boolean[][] map;
	static boolean isParity;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new boolean[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for (int c = 1; c <= N; c++) {
				if (tokens.nextToken().equals("0"))
					map[r][c] = false;
				else
					map[r][c] = true;
			}
		}
		// 입력완료
//		for (boolean[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		isParity = true;
		
		rowParityCheck();
		colParityCheck();
		
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {
				
			}
		}
		
		
		
		
	}

	private static void rowParityCheck() {
		isParity = true;
		for (int r = 1; r < N+1; r++) {
			int sum = 0;
			for (int c = 1; c < N+1; c++) {
				if(isParity && sum % 2 != 0) {
					isParity = false;
				}
				else if(!isParity && sum % 2 != 0) {
					output.append("Corrupt");
					return;
				}
			}
		}
		return;
	}
	private static void colParityCheck() {
		for (int c = 1; c < N+1; c++) {
			for (int r = 1; r < N+1; r++) {
				
			}
		}
	}


	static String src = "4\r\n" + "1 0 1 0\r\n" + "0 0 1 0\r\n" + "1 1 1 1\r\n" + "0 1 0 1";
}
