package ps.정올.Beginner.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2813_소수의개수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M, N;
	static boolean[] prime = new boolean[2000001];
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		eratosthenes();
		int cnt = 0;
		for (int i = M; i <= N; i++) {
			if(prime[i])cnt++;
		}
		System.out.println(cnt);
	}

	private static void eratosthenes() {
		for (int n = 2; n <= N; n++) {
			prime[n] = true;
		}
		for (int n = 2; n*n <= N; n++) {
			for (int i = n*n; i <= N; i+=n) {
				prime[i] = false;
			}			
		}
	}
}
