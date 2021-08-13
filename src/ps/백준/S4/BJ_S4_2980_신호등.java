package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_2980_신호등 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, L;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		
		for(int n =0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			
		}
	}

	static String src = "4 30\r\n" + 
			"7 13 5\r\n" + 
			"14 4 4\r\n" + 
			"15 3 10\r\n" + 
			"25 1 1";
}
