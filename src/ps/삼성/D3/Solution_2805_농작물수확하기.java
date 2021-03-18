package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 3.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class Solution_2805_농작물수확하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static String[] tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N;
	static int [][] farm;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			N = Integer.parseInt(input.readLine());
			farm = new int[N][N];
			for (int r = 0; r < N; r++) {
				tokens = input.readLine().split("");
				for (int c = 0; c < N; c++) {
					farm[r][c] = Integer.parseInt(tokens[c]);
				}
			}
			//입력확인
			for (int[] row : farm) {
				System.out.println(Arrays.toString(row));
			}
			
			//////
			output.append("#").append(t).append(" ").append(answer);
			System.out.println(output);
		}
	}
}
