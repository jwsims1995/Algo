package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_B1_2839_설탕배달 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		//3과 5kg 봉지를 나눠 Nkg 배달 . 최소 봉지수는?
		int[] dp = new int[N+1];
		Arrays.fill(dp, 5000);
		dp[3] = 1;
		if(N>=5) dp[5] = 1;
		
		for(int i=6; i<=N;i++) {
				dp[i] = Math.min(dp[i-5], dp[i-3]) + 1;
		}
		
		System.out.println(dp[N] < 5000 ? dp[N] : -1);

	}
	static String src ="18";
}
