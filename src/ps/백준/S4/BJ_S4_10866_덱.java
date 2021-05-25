package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_10866_덱 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, size;
	static int[] deque, tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N =Integer.parseInt(input.readLine());
		deque = new int[N];
		tmp = deque;
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			switch(tokens.nextToken()) {
			
			/*
			push_back X: 정수 X를 덱의 뒤에 넣는다.
			pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			size: 덱에 들어있는 정수의 개수를 출력한다.
			empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
			front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/
			
			case "push_front": 
				push_front(Integer.parseInt(tokens.nextToken()));
//				System.out.println(Arrays.toString(deque));
				break;
			case "push_back": 
				push_back(Integer.parseInt(tokens.nextToken()));
//				System.out.println(Arrays.toString(deque));
				break;
			case "pop_front": 
				output.append(pop_front()).append("\n");
				//System.out.println(Arrays.toString(deque));
				break;
			case "pop_back": 
				output.append(pop_back()).append("\n");
				//System.out.println(Arrays.toString(deque));
				break;
			case "size":
				output.append(size()).append("\n");
				//System.out.println(Arrays.toString(deque));
				break;
			case "empty": 
				output.append(empty()).append("\n");
				//System.out.println(Arrays.toString(deque));
				break;
			case "front": 
				output.append(front()).append("\n");
				//System.out.println(Arrays.toString(deque));
				break;
			case "back": 
				output.append(back()).append("\n");
				//System.out.println(Arrays.toString(deque));
				break;
			}
			
		}
		System.out.println(output);
		
	}
	static void push_front(int n) {
		if(size==0)deque[size++] = n;
		else {
			for (int s = size-1; s < size; s++) {
				deque[s+1] = tmp[s];
			}
			deque[0] = n;
			size++;
		}
	}
	static void push_back(int n) {
		deque[size++] = n;
	}
	static int pop_front() {
		if(size==0)return -1;
		int temp = deque[0];
		for (int s = 1; s < size; s++) {
			deque[s-1] = tmp[s];
		}
		//System.out.println("@@@"+size);
		deque[--size] = 0;
		return temp;
	}
	static int pop_back() {
		if(size==0)return -1;
		int tmp = deque[--size];
		deque[size] = 0;
		return tmp;
	}
	static int front() {
		if(size==0)return -1;
		return deque[0];
	}
	static int back() {
		if(size==0)return -1;
		
		return deque[size-1];
	}
	static int size() {
		return size;
	}
	static int empty() {
		if(size == 0)return 1;
		else return 0;
	}

}
