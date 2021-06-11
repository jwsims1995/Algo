package ps.정올.Beginner.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1523_별삼각형1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		if(!isIn(N,M)) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		switch(M){
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
	private static boolean isIn(int n, int m) {
		return n>=0 && n<=100 && 1<=m && m<=3;
	}
	private static void sol3() {
		for (int n = 0; n < N; n++) {
			for (int i = n+1; i < N; i++) {
				System.out.printf(" ");
			}
			for (int i = 0; i < 2*n+1; i++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	private static void sol2() {
		for (int n = 0; n < N; n++) {
			for (int i = N-n; i > 0; i--) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	private static void sol1() {
		for (int n = 0; n < N; n++) {
			for (int i = 0; i <= n; i++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
}
