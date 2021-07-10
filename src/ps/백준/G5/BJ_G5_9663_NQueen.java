package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_9663_NQueen {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt;
	static int[] col;
	static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		col = new int[N+1];
		
		nQueen(0);
		System.out.println(cnt);
	}


	private static void nQueen(int row) {
		if(!isAvailable(row)) {
			return;
		}
		
		if(row == N) {
			cnt++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			col[row+1] = i;
			nQueen(row+1);

		}
	}

	private static boolean isAvailable(int row) {
		for (int i = 1; i < row; i++) {
			if(col[i] == col[row] || Math.abs(col[i] - col[row]) == row - i) {
				return false;
			}
		}
		return true;
	}




	private static String src = "8";
}
