package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_11060_점프점프 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] dp, map;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		map = new int[N];
		tokens =new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(tokens.nextToken());
		}
		System.out.println(Arrays.toString(map));
		dp[0] = 0;
		for(int i=0; i<N; i++) {
			int num = map[i];
			for(int j=1; j<=num; j++) {
				if(i+j >= N) continue;
				dp[i+j] = Math.min(dp[i] + 1, dp[i+j]);
			}
		}
		System.out.println(Arrays.toString(dp));
		
		System.out.println((dp[N-1]>=0 && dp[N-1]<=1000) ? dp[N-1] :-1 );
	}

	static String src = "10\n" + 
			"1 0 0 1 3 2 1 5 4 2";
}
