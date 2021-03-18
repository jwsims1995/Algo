package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 4.
 * @author Jaewon
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV14eWb6AAkCFAYD&probBoxId=AXdrBVk6tdcDFAS5&type=PROBLEM&problemBoxTitle=0204&problemBoxCnt=1
 * @mem
 * @time
 * @caution
 */

//public class Solution_1218_괄호짝짓기 {
//	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//	static StringBuilder output = new StringBuilder();
//	static StringTokenizer tokens;
//	static int N;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		for (int t = 1; t <= 10; t++) {
//			N = Integer.parseInt(input.readLine());
//			Stack<Character> stack = new Stack<Character>();
//			int answer = 0;
//			String line = input.readLine();
//			for (int n = 0; n < N; n++) {
//				char c = line.charAt(n);
//				if(c == ')' && stack.peek() == '(') stack.pop();
//				else if(c == ']' && stack.peek() == '[') stack.pop();
//				else if(c == '}' && stack.peek() == '{') stack.pop();
//				else if(c == '>' && stack.peek() == '<') stack.pop();
//				else stack.push(c);
//			}
//			System.out.println(stack);
//			if(stack.isEmpty()) answer = 1;
//			else answer = 0;
//			output.append("#").append(t).append(" ").append(answer).append("\n");
//		}
//		System.out.println(output);
//	}
//}


public class Solution_1218_괄호짝짓기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(input.readLine());
			String line = input.readLine();
			int answer = 0;
			int[] spell = new int[4];
			for (int i = 0; i < spell.length; i++) {
				spell[i] = 0;
			}
			for (int n = 0; n < N; n++) {
				char c = line.charAt(n);
				if(c == '(') spell[0]++;
				else if(c == ')') spell[0]--;
				
				else if(c == '[') spell[1]++;
				else if(c == ']') spell[1]--;
				
				else if(c == '{') spell[2]++;
				else if(c == '}') spell[2]--;
				
				else if(c == '<') spell[3]++;
				else if(c == '>') spell[3]--;
			}
			for (int i = 0; i < spell.length; i++) {
				answer=1;
				if(spell[i] != 0) {
					answer = 0;
					break;
				}
				
			}
			output.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(output);

	}
}