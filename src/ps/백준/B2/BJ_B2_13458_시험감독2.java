package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_B2_13458_시험감독2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static long total, B, C;
	static long[] A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		A = new long[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			A[n] = Long.parseLong(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		B = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		for(int n=0; n<N; n++) {
			if(A[n] <= B) {
				total+=1;
				continue;
			}
			total += (A[n]-B)/C + 1;
			if((A[n]-B)%C > 0) total+=1;
		}
		System.out.println(total);


	}
	static String src = "5\n" + 
			"10 9 10 9 10\n" + 
			"7 2";

}
