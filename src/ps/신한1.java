package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신한1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		String line = input.readLine();
		tokens = new StringTokenizer(line);
		
		int sum = 0;
		while(tokens.hasMoreTokens()) {
			sum += Math.pow(Integer.parseInt(tokens.nextToken()), 2);
		}
		System.out.println(sum % 10);
	}
}
