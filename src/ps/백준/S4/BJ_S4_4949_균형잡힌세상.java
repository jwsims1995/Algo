package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_4949_균형잡힌세상 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Stack<Character> stack = new Stack<>();
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		while(true) {
			char[] line = input.readLine().toCharArray();
			if(line[0] == '.')break;
			flag = false;
			stack.removeAllElements();
			for (int l = 0; l < line.length; l++) {
				if(line[l] == '(' || line[l] == '[')stack.add(line[l]);
				
				else if(line[l] == ')' || line[l] == ']') {
					if(stack.isEmpty()) {
						flag = true;
						//output.append("no\n");
						break;
					}else {
						
						if(stack.peek() == '(') {
							if(line[l] == ')')stack.pop();
							else {
								flag = true;
								//output.append("no\n");
								break;
							}
						}else {//  '['
							if(line[l] == ']')stack.pop();
							else {
								flag = true;
								//output.append("no\n");
								break;
							}
						}
					}
				}
			}
			if(!stack.isEmpty() || flag)output.append("no\n");
			else if(!flag) output.append("yes\n");
			//System.out.println(output);
		}
		System.out.println(output);
	}

}
