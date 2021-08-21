package ps.백준.S2;

import java.io.*;
import java.util.*;

public class BJ_S2_123더하기3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		int size = dp.length;
		for(int i=4; i< size; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;

		}
		for(int n=0 ;n<N; n++) {
			int num = Integer.parseInt(input.readLine());
			output.append(dp[num]).append("\n");

		}
		System.out.println(output);
	}

	static String src = "3\r\n" + "4\r\n" + "7\r\n" + "10";
}
