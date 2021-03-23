package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1149_RGB거리 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[][] cost, dp;
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		cost = new int[N+1][3];
		dp = new int[N+1][3];
		for (int n = 1; n <= N; n++) {
			tokens = new StringTokenizer(input.readLine());
			cost[n][Red] = Integer.parseInt(tokens.nextToken());
			cost[n][Green] = Integer.parseInt(tokens.nextToken());
			cost[n][Blue] = Integer.parseInt(tokens.nextToken());
		}
		
		for (int i = 2; i <= N; i++) {
			cost[i][Red] += Math.min(cost[i-1][Blue], cost[i-1][Green]);
			cost[i][Green] += Math.min(cost[i-1][Blue], cost[i-1][Red]);
			cost[i][Blue] += Math.min(cost[i-1][Red], cost[i-1][Green]);
		}
		
		System.out.println(Math.min(cost[N][Red], Math.min(cost[N][Green], cost[N][Blue])));
	}

	static String src = "3\r\n" + 
			"26 40 83\r\n" + 
			"49 60 57\r\n" + 
			"13 89 99";
}
