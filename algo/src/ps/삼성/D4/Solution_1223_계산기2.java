package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1223_계산기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static char spell[];

	static int priority(char c) {
		switch (c) {
		case '+':
			return 0;
		case '*':
			return 1;
		default:
			return -1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		Queue<Character> queue = new LinkedList<Character>();
		Stack<Character> operator = new Stack<>();
		Stack<Integer> operand = new Stack<>();

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(input.readLine());
			char c = '0';
			String line = input.readLine();
			
			for (int n = 0; n < N; n++) {
				c = line.charAt(n);
				if (c == '+') {
					while (!operator.isEmpty()) {
						queue.add(operator.pop());
					}
					operator.push(c);
				} else if (c == '*') {
					while (!operator.isEmpty() && operator.peek() != '+') {
						queue.add(operator.pop());
					}
					operator.push(c);
				} else {
					queue.add(c);
				}
			}
			while(!operator.isEmpty())queue.add(operator.pop());

				///// 후위연산
				// 계산
				int result = 0;
				while(!queue.isEmpty()) {
					char q = queue.poll();
					if (q == '+') {
						result = operand.pop() + operand.pop();
						operand.add(result);
					} else if (q == '*') {
						result = operand.pop() * operand.pop();
						operand.add(result);
					} else {// 정수
						operand.add(q - '0');
					}
				}
			output.append("#" + t +" " + operand.pop() + "\n");
			}
		System.out.println(output);
		}
	}


