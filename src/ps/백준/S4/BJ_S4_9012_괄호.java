package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_9012_괄호 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T= Integer.parseInt(input.readLine());
		for (int t = 0; t <T; t++) {
			char[] c = input.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < c.length; i++) {
				if(c[i] == ')') {
					if(stack.isEmpty()) {
						stack.add(c[i]);
						break;
					}
					else if(stack.peek() == '(') {
						stack.pop();
						continue;
					}
				}
				stack.add(c[i]);
			}
			if(stack.isEmpty()) output.append("YES\n");
			else output.append("NO\n");
		}
		System.out.println(output);
	}

}
