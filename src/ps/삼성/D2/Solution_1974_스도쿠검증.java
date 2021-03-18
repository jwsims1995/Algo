package ps.삼성.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 9.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class Solution_1974_스도쿠검증 {
	static int[][] puzzle;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		puzzle = new int[9][9];
		int T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			for (int r = 0; r < 9; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < 9; c++) {
					puzzle[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}//입력완료
			

			
		}

	}
	
	static boolean checkRow(int c) {
		boolean[] flag = new boolean[9];

		for (int r = 0; r < 9; r++) {
			if(flag[puzzle[r][c]-1])
				return false;
			flag[puzzle[r][c]-1] = true;
		}
		return true;
	}
	static boolean checkCol(int r) {
		boolean[] flag = new boolean[9];

		for (int c = 0; c < 9; c++) {
			if(flag[puzzle[r][c]-1])
				return false;
			flag[puzzle[r][c]-1] = true;
		}
		return true;
		
	}
	static boolean check3x3(int r, int c) {
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {				
				
			}
			
		}
		return false;
		
	}
}
