package ps.정올.Beginner.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1002_최대공약수최소공배수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] num;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		num = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(tokens.nextToken());
		}
		int tmp1 = num[0];
		int tmp2 = 1;
		for (int n = 0; n < N; n++) {
			tmp1 = gcd(tmp1, num[n]);
			tmp2 = lcm(tmp2, num[n]);
		}
		
		System.out.printf("%d %d",tmp1, tmp2);
	}
	private static int gcd(int A, int B) {
		if(B==0)return A;
		return gcd(B, A%B);
	}
	private static int lcm(int A, int B) {
		return A*B/gcd(A,B);
	}
}
