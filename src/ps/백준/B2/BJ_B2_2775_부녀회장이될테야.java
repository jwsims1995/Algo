package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B2_2775_부녀회장이될테야 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,k,N,sum; //k층 n호
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			sum=0;
			k = Integer.parseInt(input.readLine());
			N = Integer.parseInt(input.readLine());
			floor(k,N);
			System.out.println(sum);
		}
	}
	private static void floor(int k, int N) {
		if(k==0) {
			sum+=N;
			return;
		}
		for (int n = 1; n <= N; n++) {			
			floor(k-1, n);
		}
	}
	static String src = "2\r\n" + 
			"1\r\n" + 
			"3\r\n" + 
			"2\r\n" + 
			"3";
}
