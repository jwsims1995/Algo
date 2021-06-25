package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1107_리모컨 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[] N;
	static String copy;
	static int M, sum;
	static boolean[] broke;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		N = input.readLine().toCharArray();
		copy = String.valueOf(N);
		M = Integer.parseInt(input.readLine());
		broke = new boolean[10];
		tokens = new StringTokenizer(input.readLine());
		for (int m = 0; m < M; m++) {
			broke[Integer.parseInt(tokens.nextToken())] = true;			
		}//입력

		for (int n = 0; n < N.length; n++) {
			//if(broke[N[n]-'0']) N[n] = (char) (findOtherKey(N[n]) +'0') ;
			if(broke[N[n]-'0']) N[n] = (char) (findOtherKey(N[n]-'0') +'0') ;
		}
		int a = Integer.parseInt(copy);
		int b = Integer.parseInt(String.valueOf(N));
		
		sum += (Math.abs(a-b) + N.length);
		
		System.out.println(sum);
	}

	private static int findOtherKey(int n) {
		int idx=10;
		int key = 0;
		for (int b = 0; b < broke.length; b++) {
			if(!broke[b]) {
				
				//절대값 n - b 가 최소
				idx = Math.min(idx, Math.abs(n-b));
			}
		}
		key = n-idx;
		if(key < 0) key = n+idx;
		
		return key;
	}


	private static String src = "500000\r\n" + 
			"8\r\n" + 
			"0 2 3 4 6 7 8 9"; //5
}
