package ps.정올.Beginner.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO_2814_이진수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, to;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		to = Integer.parseInt(tokens.nextToken());
		Stack<Integer> stack = new Stack<>();
		if(to == 2) {
			while(true) {
				if(N==0)break;
				stack.add(N%2);
				N/=2;
			}
			while(!stack.isEmpty()) {
				output.append(stack.pop());				
			}
			System.out.println(output);
		}
		else if(to == 8) {
			while(true) {
				if(N==0)break;
				stack.add(N%8);
				N/=8;
			}
			while(!stack.isEmpty()) {
				output.append(stack.pop());				
			}
			System.out.println(output);
		}
		else if(to == 16) {
			while(true) {
				if(N==0)break;
				stack.add(N%16);
				N/=16;
			}
			while(!stack.isEmpty()) {
				int pop = stack.pop();
				char c = 'A';
				if(pop>=10) {
					c = (char) (c + (pop-10));
					output.append(c);
					continue;
				}
				output.append(pop);				
			}
			System.out.println(output);
		}
		
	}
}