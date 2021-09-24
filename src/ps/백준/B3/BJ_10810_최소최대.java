package ps.백준.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BJ_10810_최소최대 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input  = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while(tokens.hasMoreTokens()) {
			int num = Integer.parseInt(tokens.nextToken());
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		output.append(min).append(" ").append(max);
		System.out.println(output);
	}
	static String src = "5\n" + 
			"20 10 35 30 7";
}
