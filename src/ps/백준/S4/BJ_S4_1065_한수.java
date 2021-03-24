package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_1065_한수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine()); // 1<= N <= 1000
		for (int n = 1; n <= N; n++) {
			if(n<100) cnt++;
			else {
				if(n == 1000) break;
			}
		}
		
	}

	static String src = "110";
}
