package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S3_17413_단어뒤집기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output= new StringBuilder();
	static StringTokenizer tokens;
	static String s;
	static char c;
	static boolean isIn;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		s = input.readLine();
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			
			if(c == '<') {
				isIn = true;
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(c);
			}
			else if( c == '>') {
				isIn = false;
				System.out.print(c);
			}
			else if(isIn) {
				System.out.print(c);
			}
			else if(!isIn) {
				if(c==' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(c);
				}
				else {
					stack.push(c);
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
