package ps.정올.Beginner.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2071_파스칼삼각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		if (!isIn(N, M)) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
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
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (i == N / 2 + 2)
				flag = true;
			
			if (!flag) {
				for (int j = 1; j <= i; j++) {
					System.out.printf("%d ", j);
				}
			} else {
				for (int j = 1; j <= N-i+1; j++) {
					System.out.printf("%d ", j);
				}
			}
			System.out.println();
		}
	}

	private static void sol2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i*2; j++) {
				System.out.printf(" ");
			}
			for (int j = 0; j < (N - i) * 2 - 1; j++) {
				System.out.printf("%d ", i);
			}
			System.out.println();
		}
	}

	private static void sol1() {
		int cnt = 1;
		int tmp = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if (i % 2 != 0) {
					System.out.printf("%d ", cnt++);
					tmp = cnt + i;
				} else {
					System.out.printf("%d ", tmp--);
					cnt = tmp + i + 1;
				}
			}
			System.out.println();
		}

	}

	private static boolean isIn(int n, int m) {
		return 1 <= n && n <= 100 && n % 2 != 0 && 1 <= m && m <= 3;
	}
}
