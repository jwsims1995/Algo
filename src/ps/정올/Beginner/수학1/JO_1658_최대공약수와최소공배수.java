package ps.정올.Beginner.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1658_최대공약수와최소공배수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int A,B;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		System.out.println(gcd(A,B));
		System.out.println(lcm(A,B));
	}
	private static int gcd(int A, int B) {
		if(B==0)return A;
		return gcd(B,A%B);
	}

	private static int lcm(int A, int B) {
		return A * B / gcd(A,B);
	}
}
