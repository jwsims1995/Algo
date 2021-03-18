package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 16.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class BJ_B1_3985_롤케이크 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int L, N;
	static int[] P, K;
	static int[] cake;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		L = Integer.parseInt(input.readLine());
		N = Integer.parseInt(input.readLine());
		P = new int[N];
		K = new int[N];
		cake = new int[L];
		int expectMax = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			P[i] = Integer.parseInt(tokens.nextToken());
			K[i] = Integer.parseInt(tokens.nextToken());
			if(max == K[i]-P[i])continue;
			max = max(max, K[i] - P[i]);
			if(max == K[i]-P[i]) expectMax = max;

		}
//		System.out.println(Arrays.toString(P));
//		System.out.println(Arrays.toString(K));
		for (int i = 0; i < N; i++) {
			for (int j = P[i]; j <= K[i]; j++) {
				if(cake[j-1]>0)continue;
				cake[j-1] = i+1;
			}
		}
		//System.out.println(Arrays.toString(cake));
		
		int[] answer = new int[N];
		int ans=0;
		int maxAns = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < L; j++) {
				if(cake[j] > 0 && cake[j] == i+1)answer[i]++;
			}
			if(answer[i] == maxAns) continue;
			maxAns = max(answer[i], maxAns);
			if(answer[i] == maxAns) ans = i+1;
		}
		
		//System.out.println(Arrays.toString(answer));
		System.out.println(expectMax);
		System.out.println(ans);


	}
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
