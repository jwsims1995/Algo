package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_14567_선수과목 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static boolean[][] subject;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 과목수
		M = Integer.parseInt(tokens.nextToken()); // 선수조건 수
		subject = new boolean[N+1][N+1];
		int[] dp = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int pre = Integer.parseInt(tokens.nextToken());
			int now = Integer.parseInt(tokens.nextToken());
			subject[pre][now] = true;
		}
		
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			
			for (int j = 1; j < i; j++) {
				if(subject[j][i]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		for (int now = 1; now <= N; now++) {
			output.append(dp[now]).append(" ");
		}
		System.out.println(output);
	}

	private static String src = "6 4\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"2 5\n" + 
			"4 5"; //1 2 3
}
