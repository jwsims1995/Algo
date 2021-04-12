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
<<<<<<< HEAD
		dp[0] = 0;
		// B -> O --> J
		if(road[0] != 'B') { //첫자리가 B가 아니면 종료
			System.out.println(-1);
			System.exit(0);
		}
		
		for (int i = 0; i < N; i++) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			for (int j = i+1; j < N; j++) {
				if(road[i] == 'B' && road[j] == 'O')
					dp[j] = (int) Math.min(dp[j], dp[i]+ Math.pow(j-i, 2));
				if(road[i] == 'O' && road[j] == 'J')
					dp[j] = (int) Math.min(dp[j], dp[i]+ Math.pow(j-i, 2));
				if(road[i] == 'J' && road[j] == 'B')
					dp[j] = (int) Math.min(dp[j], dp[i]+ Math.pow(j-i, 2));
			}
		}
		
		if(dp[N-1] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[N-1]);
=======
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
>>>>>>> branch 'master' of https://github.com/jwsims1995/Algo.git
	}

	static String src = "9\r\n" + "BOJBOJBOJ";
}
