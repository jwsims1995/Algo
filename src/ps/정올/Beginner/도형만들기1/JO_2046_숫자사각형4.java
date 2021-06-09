package ps.정올.Beginner.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_2046_숫자사각형4 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		switch (M) {
		case 1:
			sol1();
			break;

		case 2:
			sol2();
			break;

		case 3:
			sol3();
			break;
		}
	}

	private static void sol3() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				System.out.printf("%d ",r*c);
			}
			System.out.println();
		}
	}

	private static void sol2() {
		for (int r = 0; r < N; r++) {
			if(r%2==0) {
				for (int c = 1; c <= N; c++) {
					System.out.printf("%d ",c);
				}
				System.out.println();
			}
			else {
				for (int c = N; c > 0; c--) {
					System.out.printf("%d ",c);
				}
				System.out.println();
			}
			
		}
	}

	private static void sol1() {
		for (int r = 1; r <= N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.printf("%d ",r);
			}
			System.out.println();
		}
	}
}
