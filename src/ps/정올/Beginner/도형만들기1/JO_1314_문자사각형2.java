package ps.정올.Beginner.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1314_문자사각형2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	//'A' = 65
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine()); // 1이상 100이하
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(c%2 == 0) {
					System.out.printf("%c ", 65 +  (c * N + r) % 26);
				}else {
					System.out.printf("%c ", 65 + ( (c+1) * N - r-1)%26);
				}
			}
			System.out.println();
		}
	}
}
