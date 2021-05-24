package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_10828_스택 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, size;
	static int[] stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N =Integer.parseInt(input.readLine());
		stack = new int[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			switch(tokens.nextToken()) {
			case "top": 
				output.append(top()).append("\n");
				break;
			case "pop": 
				output.append(pop()).append("\n");
				break;
			case "size":
				output.append(size()).append("\n");
				break;
			case "empty": 
				output.append(empty()).append("\n");
				break;
			case "push": 
				push(Integer.parseInt(tokens.nextToken()));
				break;
			}
			
		}
		System.out.println(output);
		
	}
	static void push(int n) {
		stack[size++] = n;
	}
	static int top() {
		if(size==0)return -1;

		return stack[size-1];
	}
	static int pop() {
		if(size==0)return -1;
		
		int tmp = stack[--size];
		stack[size] = 0;
		return tmp;
	}
	static int size() {
		return size;
	}
	static int empty() {
		if(size == 0)return 1;
		else return 0;
	}
}
