package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_12026_BOJ거리 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static char[] road;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		String line = input.readLine();
		road = line.toCharArray();
		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (road[i - 1] == 'B' && road[i] == 'O')
					dp[i] = (int) Math.min(dp[i], dp[i - j] + Math.pow(i - j, 2));
				else if (road[i - 1] == 'O' && road[i] == 'J')
					dp[i] = (int) Math.min(dp[i], dp[i - j] + Math.pow(i - j, 2));
				else if (road[i - 1] == 'J' && road[i] == 'B')
					dp[i] = (int) Math.min(dp[i], dp[i - j] + Math.pow(i - j, 2));
				else if(road[i-1] == road[i])
					dp[i] = dp[i - 1] + 1;
				
			}
			System.out.println(dp[i]);
		}
		System.out.println(dp[N]);
	}

	static String src = "9\r\n" + "BOJBOJBOJ";
}
