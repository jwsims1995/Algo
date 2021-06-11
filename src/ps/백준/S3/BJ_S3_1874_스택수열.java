package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S3_1874_스택수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		int cnt = 1;

		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(input.readLine());
			while(true) {
				if(stack.isEmpty()) {
					stack.add(cnt++);
					output.append("+\n");					
				}
				if(cnt>N+1) {
					System.out.println("NO");
					System.exit(0);
				}
				if(stack.peek() == num) {
					stack.pop();
					output.append("-\n");
					break;
				}
				stack.add(cnt++);
				output.append("+\n");
			}
		}
		System.out.println(output);

	}
}
