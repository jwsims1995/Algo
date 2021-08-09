package ps.백준.S2;

import java.io.*;
import java.util.*;

public class BJ_S2_15663_N과M9_3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(arr);
		
		permutation();
	}
	private static void permutation(int toChoose, int[] choosed) {
		
	}
	private static void permutation(int toChoose, int[] choosed) {
		
	}

	private static void permutation(int toChoose, int[] choosed) {
	
	}
	static String src = "8 8\r\n" + 
			"1 2 3 4 5 6 7 8";
}
