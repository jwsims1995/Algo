package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer output = new StringBuffer();
	static StringTokenizer tokens;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		Stack<Tower> stack = new Stack<Tower>();
		for (int n = 1; n <= N; n++) {
			int num = Integer.parseInt(tokens.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek().height >= num) {
					output.append(stack.peek().pos + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) output.append("0 ");
			stack.push(new Tower(num, n));
			
		}
		//System.out.println(stack);//입력확인
		System.out.println(output);

		//
	}
	
	static class Tower{
		int height;
		int pos;
		
		public Tower(int height, int pos) {
			this.height = height;
			this.pos = pos;
		}
		
	}
}
