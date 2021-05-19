package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_14501_퇴사 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, max;
	static int[] day;
	static int[] val;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		day = new int[N+1];
		val = new int[N+1];
		dp = new int[N+2];
		
		max = Integer.MIN_VALUE;
		for (int n = 1; n <= N; n++) {
			tokens = new StringTokenizer(input.readLine());
			day[n] = Integer.parseInt(tokens.nextToken());
			val[n] = Integer.parseInt(tokens.nextToken());
		}//입력완료
		for (int n = 1; n <= N; n++) {
			if(isIn(n+day[n])) 
				dp[n+day[n]] = Math.max(dp[n]+val[n], dp[n+day[n]]);
			dp[n+1] = Math.max(dp[n+1], dp[n]);
			//max = Math.max(max, dp[n+1]);
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[N+1]);
	}

	private static boolean isIn(int i) {
		return i<=N+1;
	}
}
