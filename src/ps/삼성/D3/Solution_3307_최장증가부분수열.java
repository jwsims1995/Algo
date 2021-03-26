package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N;
	static int[] arr,dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			arr = new int[N];
			dp = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for (int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(tokens.nextToken());
			}//입력완료
			int max = 0;
			for (int i = 0; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
				if(max < dp[i]) max = dp[i];
			}
			output.append("#" + t + " " + max + "\n");
		}
		System.out.println(output);
	}
	static String src = "2\r\n" + 
			"5\r\n" + 
			"1 3 2 5 4\r\n" + 
			"6\r\n" + 
			"4 2 3 1 5 6\r\n";
}
