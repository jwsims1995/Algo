package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_12101_123더하기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] dp;
	static int N, P;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		P = Integer.parseInt(tokens.nextToken());
		
		dp= new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		
		
		
	}
	
	static String src = "2 3 1\r\n";
}
