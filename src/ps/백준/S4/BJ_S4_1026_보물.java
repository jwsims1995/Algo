package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S4_1026_보물 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, sum;
	static int[] A,B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		A = new int[N];
		B = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			B[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);

		///입력완료
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(B));
		System.out.println(S(N));
		
	}
	private static int S(int N) {
		for (int n = 0; n < N; n++) {
			sum += A[N-n-1]*B[n];
		}
		return sum;
	}

}
