package ps.삼성.D4;
/**
 * @since 2021. 2. 4.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5432_쇠막대기자르기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens ;
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			String line = input.readLine();
			char[] arr = line.toCharArray();
			
			int cnt = 0;
			int total = 0;
			
			for (int i = 0; i < arr.length; i++) {
				//쇠막대기 시작
				if(arr[i]== '(' && i+1 < arr.length && arr[i+1]!=')') {
					cnt++;
				} //쇠막대기 끝
				if(arr[i]== ')' && arr[i-1]!='(') {
					cnt--;
					total++;
				}
				if(arr[i]== ')' && arr[i-1]!='(') {
					total += cnt;
				}
			}
		}
	}
	
	static void stack(char[] arr) {
		Stack<Character> stack = new Stack<Character>();
		int total =0 ;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == '(') {
				stack.push(arr[i]);
			}
			//레이저면
			else if(arr[i] == ')' && arr[i-1] == '(') {//범위 체크도 해라 
				stack.pop();
				total += stack.size();
			}
			else if(arr[i]==')' && arr[i-1] == ')') {
				stack.pop();
				total+=1;
			}
		}
		System.out.println();
	}
}
