package ps.정올.Beginner.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1740_소수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M, N, sum;
	static boolean[] prime;
	
	public static void main(String[] args) throws IOException {
		M = Integer.parseInt(input.readLine());
		N = Integer.parseInt(input.readLine());// 1<= M <= N <= 10000
		prime = new boolean[N + 1];
		eratostenes();
		
//		System.out.println(Arrays.toString(prime));
		int min = Integer.MAX_VALUE;
		boolean noPrime = true;
		for (int i = M; i <= N; i++) {
			if(prime[i]) {
				noPrime = false;
				sum+=i;
				min = Math.min(min, i);
			}
		}
		if(!noPrime) {
			System.out.println(sum);
			System.out.println(min);			
		}else {
			System.out.println(-1);
		}
	}

	private static void eratostenes() {
		for (int i = 2; i <= N; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= N; i++) {
			for (int j = i * i; j <= N; j += i) {
				prime[j] = false;
			}
		}

	}
}
