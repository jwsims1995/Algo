package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_2798_블랙잭 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M, ans;
	static int[] card;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		card = new int[N];
		for (int n = 0; n < N; n++) {
			card[n] = Integer.parseInt(tokens.nextToken());
		}
		combination(3, new int[3], 0);
		System.out.println(ans);
	}
	private static void combination(int toChoose, int[] choosed, int idx) {
		if(toChoose == 0) {
			int sum  = 0;
			for (int i = 0; i < choosed.length; i++) {
				sum+=choosed[i];
			}
			if(sum<=M) {
				min = Math.min(Math.abs(sum-M), min);
				if(min == Math.abs(sum-M))
					ans = sum;
				return;				
			}
			return;
		}
		for (int i = idx; i < card.length; i++) {
			choosed[choosed.length - toChoose] = card[i];
			combination(toChoose-1, choosed, i+1);
		}
	}
	
	static String src=  "10 500\r\n" + 
			"93 181 245 214 315 36 185 138 216 295";
}
