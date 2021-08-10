package ps.백준.S2;

import java.io.*;
import java.util.*;

public class BJ_S2_15663_N과M9_3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(arr);
		
		permutation(M, new int[M], new boolean[M]);
	}
	private static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if(toChoose == 0) {
			return;
		}
		for(int i =0 ;i<choosed.length;i++) {
			choosed[choosed.length-toChoose] = arr[i];
			visited[]
		}
	}
	private static void combination(int toChoose, int[] choosed) {
		
	}

	private static void powerSet(int toChoose, int[] choosed) {
	
	}
	static String src = "8 8\r\n" + 
			"1 2 3 4 5 6 7 8";
}
