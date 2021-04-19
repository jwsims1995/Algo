package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_professional조합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, R, T;
	static final int Mod = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T= Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			long[] fact= new long[N+1];
			fact[0] = 1;
			for (int f = 1; f <= N; f++) {
				fact[f] = ( f * fact[f-1] ) % Mod;
			}
			
			long bottom = ( (fact[N-R]) * (fact[R]) ) % Mod ;
			
			long rebottom = fermat(bottom, Mod-2);
			
			output.append("#" + t + " " + (rebottom * fact[N] % Mod) + "\n");

		}
		System.out.println(output);
	}
	
	private static long fermat(long bottom, int i) {
		if(i == 0) return 1;
		long tmp = fermat(bottom, i/2);
		long ret = (tmp * tmp) % Mod;
		if(i % 2 == 0) return ret ;
		else return (bottom * ret) % Mod ;
	}
}
