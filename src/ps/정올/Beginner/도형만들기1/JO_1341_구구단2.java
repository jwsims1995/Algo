package ps.정올.Beginner.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1341_구구단2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int S, E;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		S = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		if(S<=E) {
			solAsc();
		}else {
			solDesc();
		}
	}

	private static void solAsc() {
		for (int e = S; e <= E; e++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %2d   ", e,i,e*i);
				if(i%3==0)System.out.println();
			}
			System.out.println();
		}
	}

	private static void solDesc() {
		for (int e = S; e >= E; e--) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %2d   ", e,i,e*i);
				if(i%3==0)System.out.println();
			}
			System.out.println();
		}
	}
}
