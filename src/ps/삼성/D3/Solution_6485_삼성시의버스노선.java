package ps.삼성.D3;

import java.io.*;
import java.util.*;

public class Solution_6485_삼성시의버스노선 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			for(int n=0; n<N; n++) {
				tokens = new StringTokenizer(input.readLine());
				A[n] = Integer.parseInt(tokens.nextToken());
				B[n] = Integer.parseInt(tokens.nextToken());
			}
			int P = Integer.parseInt(input.readLine());
			int[] C = new int[P+1];
			for(int p=1; p<=P; p++) {
				C[p] = Integer.parseInt(input.readLine());
			}

			int[] ans = new int[P+1];

			for(int n=0; n<N; n++) {
				for(int i=A[n]; i<=B[n]; i++) { // 1 2 3 ... 2 3 4 5
					ans[C[i]]++;
				}
			}
			
			output.append("#").append(t).append(" ");

			for(int i=1; i<=P;i++) {
				output.append(ans[i]).append(" ");
			}
			output.append("\n");

		}
		System.out.println(output);
	}

	static String src = "1\n" + 
			"2\n" + 
			"1 3\n" + 
			"2 5\n" + 
			"5\n" + 
			"3\n" + 
			"2\n" + 
			"4\n" + 
			"5\n" + 
			"1";
}
