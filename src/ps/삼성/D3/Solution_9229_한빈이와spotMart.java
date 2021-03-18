package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와spotMart {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, R, answer;
	static int[] weight;
	static boolean[] visited;
	static int[] choosed;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			weight = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for (int n = 0; n < N; n++) {
				weight[n] = Integer.parseInt(tokens.nextToken());
			}
			answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					int sum = weight[i] + weight[j];
					if(sum > R)continue;
					answer = Math.max(answer, sum);
				}
			}
			if(answer == 0) answer = -1;

			/////
			output.append("#"+ t + " "+ answer + "\n");
		}
		System.out.println(output);
	}


}
