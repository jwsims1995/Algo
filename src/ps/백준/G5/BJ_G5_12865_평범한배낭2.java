package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_12865_평범한배낭2 {
	static class Good implements Comparable<Good>{
		int w;
		int v;
		public Good(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		@Override
		public int compareTo(Good o) {
			if(this.w == o.w) return o.v - this.v;
			return this.w - o.w;
		}
		@Override
		public String toString() {
			return "Good [w=" + w + ", v=" + v + "]";
		}
		
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, K, ans;
	static Good [] goods;
	
	// dp[i][k] = i번째 상품까지 고려했을 때 k 무게에 담을 수 있는 최대의 가치
	static int [][] dp;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken()); // 물품의 수
		K = Integer.parseInt(tokens.nextToken()); // 가능한 무게
		goods = new Good[N+1]; // 0번 상품(하나도 선택하지 않은 경우)고려
		goods[0]= new Good(0,0);
		for(int n=1; n<=N; n++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int w = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			goods[n] = new Good(w, v);
		}
		Arrays.sort(goods);
//		System.out.println(Arrays.toString(goods));
		
		int[][] dp = new int[N+1][K+1];
		for(int n=0; n<=N; n++) {
			for(int k=0; k<=K; k++) {
				//
			}
		}
		for(int[] row: dp) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println(ans);
	}
	


	private static String src = "4 7\r\n" +
			"6 13\r\n" +
			"4 8\r\n" +
			"3 6\r\n" +
			"5 12";
}
