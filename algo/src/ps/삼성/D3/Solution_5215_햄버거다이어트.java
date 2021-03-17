package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 8.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class Solution_5215_햄버거다이어트 {
	static BufferedReader input  = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, L;
	static Material[] ms;
	static int MAX_SAT;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N =Integer.parseInt(tokens.nextToken());
			L =Integer.parseInt(tokens.nextToken());
			ms = new Material[N];
			for (int n = 0; n < N; n++) {
				tokens = new StringTokenizer(input.readLine());
				int sat = Integer.parseInt(tokens.nextToken());
				int cal = Integer.parseInt(tokens.nextToken());
				ms[n] = new Material(sat, cal);
			}
			//System.out.println(Arrays.toString(ms));
			//입력완료
			MAX_SAT = 0;

			subsetByPermutation(N, 0 , 0);
			output.append(String.format("#%d %d%n", t, MAX_SAT));
		}
		System.out.println(output);
	}
	
	static void subsetByPermutation(int toChoose, int sat, int cal) {
		if(cal > L) {
			return;
		}
		if(toChoose ==0) {
			MAX_SAT = Math.max(MAX_SAT, sat);
			return;
		}
		int idx = N - toChoose;
		subsetByPermutation(toChoose-1, sat+ms[idx].sat, cal+ms[idx].cal);
		subsetByPermutation(toChoose-1, sat, cal);
	}
	
	static class Material {
		int sat;
		int cal;
		
		public Material(int sat, int cal) {
			super();
			this.sat = sat;
			this.cal = cal;
		}

		@Override
		public String toString() {
			return "Material [sat=" + sat + ", cal=" + cal + "]";
		}
	}
}

