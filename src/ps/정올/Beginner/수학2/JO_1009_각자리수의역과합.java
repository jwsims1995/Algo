package ps.정올.Beginner.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO_1009_각자리수의역과합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output;
	static StringTokenizer tokens;
	static char[] N;
	public static void main(String[] args) throws IOException {
		for (int t = 0; t < 10; t++) {
			N = input.readLine().toCharArray();
			if(N[0] == '0')System.exit(0);
			Stack<Character> stack = new Stack<>();
			output = new StringBuilder();
			int sum = 0;
			for (int n = 0; n < N.length; n++) {
				stack.add(N[n]);
			}
			boolean zero = true;
			while(!stack.isEmpty()) {
				int tmp = stack.pop();
				if(tmp !='0')zero = false;
				if(!zero)
					output.append(tmp-'0');
				sum+= tmp-'0';
			}
			output.append(" ").append(sum);
			System.out.println(output);
		}
	}
}
