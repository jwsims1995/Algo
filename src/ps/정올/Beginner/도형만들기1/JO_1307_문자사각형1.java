package ps.정올.Beginner.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1307_문자사각형1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	//'A' = 65
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine()); // 1이상 100이하
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				System.out.printf("%c ", 65 + ((N*N - i) - N*j -1)%26 );
			}
			System.out.println();
		}
	}
}
