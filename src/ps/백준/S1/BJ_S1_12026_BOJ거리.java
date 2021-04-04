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
	static char[] spell = { 'B', 'O', 'J' };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		String line = input.readLine();
		road = line.toCharArray();
		dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 1;
		// B -> O --> J
		if(road[0] != 'B') { //첫자리가 B가 아니면 종료
			System.out.println(-1);
			System.exit(0);
		}
		int idx=1;
		boolean flag;
		for (int i = 1; i < N; i++) {
			if(road[i] != spell[idx%3]) continue;
			for (int j = i; j < N; j++) {
				flag= true;
				if(road[j] == spell[idx%3]) {
					dp[i] = (int) Math.min(dp[i], dp[j] + Math.pow(j-i, 2));
				}
			}
			idx++;
		}
		if(!flag) System.out.println(-1);
		else System.out.println(dp[N-1]);
		
		
		
		
		int ans = -1;
		if (road[0] != 'B') { // 시작이 B가 아니면 -1
			System.out.println(ans);
			System.exit(0);
		}
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (spell[idx % 3] == road[j]) {
					idx++;
					ans += Math.pow(j-i+1, 2);
					i=j;
					if(i==N-1) {
						System.out.println(ans);
						System.exit(0);
					}
					break;
				}
			}
		}
		System.out.println(-1);
	}

	static String src = "9\r\n" + 
			"BOJBOJBOJ";
}
