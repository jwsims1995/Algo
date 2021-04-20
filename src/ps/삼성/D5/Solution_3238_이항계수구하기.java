package ps.삼성.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238_이항계수구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static long N, R, P;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t =1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Long.parseLong(tokens.nextToken());
			R = Long.parseLong(tokens.nextToken());
			P = Long.parseLong(tokens.nextToken());
			
			long[] fact = new long[(int) (N+1)];
			fact[0] = 1;
			for (int f = 1; f <= N; f++) {
				fact[f] = f * fact[f-1];
			}
			long top = fact[7];
			long bottom = (fact[(int) N] * fact[(int) (N-R)]) % P;
			
			long rebottom = fermat(bottom, P-2);
			
			output.append("#" + t +" " + (rebottom * top) % P );
		}
		System.out.println(output);
	}
	private static long fermat(long bottom, long p) {
		if( p == 0) return 1;
		long tmp = fermat(bottom, p/2);
		long ret = (tmp * tmp) % P;
		if(p % 2 == 0) return ret;
		else return (bottom * ret) % P;
	}
}
