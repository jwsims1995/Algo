package ps.정올.Beginner.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1291_구구단 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int S,E; // 2부터 9 사이의 정수
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		S = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		while(!isIn(S,E)) {
			System.out.println("INPUT ERROR!");
			tokens = new StringTokenizer(input.readLine());
			S = Integer.parseInt(tokens.nextToken());
			E = Integer.parseInt(tokens.nextToken());
		}
		
		if(S <= E) {
			solAsc(S,E);
		}
		else {
			solDesc(S,E);
		}
	}

	private static boolean isIn(int s, int e) {
		return s>=2 && s<=9 && e>=2 && e<=9;
	}

	private static void solAsc(int S, int E) {
		for (int i = 1; i <= 9; i++) {
			for (int e = S; e <= E; e++) {
				System.out.printf("%d * %d = %2d   ", e,i,e*i);
			}
			System.out.println();
		}
	}
	
	private static void solDesc(int S, int E) {
		for (int i = 1; i <= 9; i++) {
			for (int e = S; e >= E; e--){
				System.out.printf("%d * %d = %2d   ", e,i,e*i);

			}
			System.out.println();
		}
	}
}
