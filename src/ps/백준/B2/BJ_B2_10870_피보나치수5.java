package ps.백준.B2;

import java.io.*;
import java.util.*;

public class BJ_B2_10870_피보나치수5 {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int[] fibo = new int[21];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int n=2; n<=N; n++) {
			fibo[n] = fibo[n-1] + fibo[n-2];
		}
		System.out.println(fibo[N]);
	}

	static String src = "0";
}
