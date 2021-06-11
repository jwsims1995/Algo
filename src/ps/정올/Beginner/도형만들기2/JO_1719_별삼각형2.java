package ps.정올.Beginner.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1719_별삼각형2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		if(!isIn(N)) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		boolean flag = false;
		for (int n = 0; n < N; n++) {
			if(n == N/2+1) flag = true;
			if(!flag) {
				for (int i = 0; i < n; i++) {
					System.out.printf(" ");
				}
				for (int i = 0; i < 2*n+1; i++) {
					System.out.printf("*");
				}
			}else {
				for (int i = n+1; i < N; i++) {
					System.out.printf(" ");
				}
				for (int i = 0; i < 2*(N-n-1)+1; i++) {
					System.out.printf("*");
				}
			}
			System.out.println();
		}
			
	}
	private static boolean isIn(int n) {
		return n>=1 && n<=100 && n%2!=0;
	}

}
