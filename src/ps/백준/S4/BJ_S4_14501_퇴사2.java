package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_14501_퇴사2 {
	static class Work{
		int day, val;
		public Work(int day, int val) {
			this.day = day;
			this.val = val;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, max;
	static Work[] works;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		dp= new int[N+2];
		works = new Work[N+1];
		for(int n=1; n<=N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int day = Integer.parseInt(tokens.nextToken());
			int val = Integer.parseInt(tokens.nextToken());
			works[n] = new Work(day, val);
		}
		for(int n=1; n<=N; n++) {
			int checkDay = n + works[n].day;
			int preDay = n;
			if(isIn(checkDay)) {
				dp[checkDay] = Math.max(dp[checkDay], dp[preDay] + works[preDay].val);				
			}
			dp[preDay+1] = Math.max(dp[preDay+1], dp[preDay]);
		}
		System.out.println(dp[N+1]);
		

	}

	private static boolean isIn(int i) {
		return i<=N+1;
	}
}
