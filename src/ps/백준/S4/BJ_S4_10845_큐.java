package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_10845_큐 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, size;
	static int[] queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N =Integer.parseInt(input.readLine());
		queue = new int[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			switch(tokens.nextToken()) {
			
			//push pop size empty front back
			case "front": 
				output.append(front()).append("\n");
				break;
			case "back": 
				output.append(back()).append("\n");
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
		queue[size++] = n;
	}
	static int pop() {
		if(size==0)return -1;
		int tmp = queue[0];
		for (int s = 1; s < size; s++) {
			queue[s-1] = queue[s];
		}
		queue[size--] = 0;
		return tmp;
	}
	
	static int front() {
		if(size==0)return -1;
		return queue[0];
	}
	static int back() {
		if(size==0)return -1;
		
		return queue[size-1];
	}
	static int size() {
		return size;
	}
	static int empty() {
		if(size == 0)return 1;
		else return 0;
	}

}
