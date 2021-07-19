package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_14888_연산자끼워넣기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] A;
	static int[] op = new int[4];
	static char[] pmmd = {'+', '-', '*', '/'};
	static List<Character> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		A = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n <N; n++) {
			A[n] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(tokens.nextToken());
		}
		while(true) {
			if(op[0] >0) {
				op[0]--;
				list.add(pmmd[0]);
			}
			else if(op[1] >0) {
				op[1]--;
				list.add(pmmd[1]);
			}
			else if(op[2] >0) {
				op[2]--;
				list.add(pmmd[2]);
			}
			else if(op[3] >0) {
				op[3]--;
				list.add(pmmd[3]);
			}
			
			if(op[0]+op[1]+op[2]+op[3] == 0) break;
		}
		//입력완료
		int size = list.size();
		permutation(N-1, new char[N-1], new boolean[size]);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	
	private static void permutation(int toChoose, char[] choosed, boolean[] visited) {
		if(toChoose == 0) {
//			System.out.println(Arrays.toString(choosed));
			cal(choosed);
			return;
		}
		int size = list.size();
		for (int i = 0; i < size ; i++) {
			if(!visited[i]) {
				choosed[choosed.length-toChoose] = list.get(i);
				visited[i] = true;
				permutation(toChoose-1, choosed, visited);
				visited[i] = false;
			}
		}
	}


	private static void cal(char[] choosed) {
		int cnt = A[0];
		for (int i = 0; i < N-1; i++) {
			if(choosed[i] == '+') {
				cnt += A[i+1];
			}
			else if(choosed[i] == '-') {
				cnt -= A[i+1];
			}
			else if(choosed[i] == '*') {
				cnt *= A[i+1];
			}
			else if(choosed[i] == '/') {
				if(cnt < 0) {
					cnt = -(Math.abs(cnt) / A[i+1]);
				}else {
					cnt /= A[i+1];					
				}
			}
		}
		max = Math.max(max, cnt);
		min = Math.min(min, cnt);
		return;
	}


	static String src = "2\n" + 
			"1 2\n" + 
			"0 1 0 0";
}