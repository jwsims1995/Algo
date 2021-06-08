package ps.정올.Beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1304_숫자사각형3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		for (int r = 1; r <= N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.printf("%d ", r+c*N);
			}
			System.out.println();
		}
	}
}
