package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_BJ_G5_13302_리조트 {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static boolean [] blackDay;
	static int [][] cost;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		cost = new int[N+1][N+1];
		blackDay = new boolean[N+1];
		tokens = new StringTokenizer(input.readLine());
		for (int i = 1; i <= M; i++) {
			blackDay[Integer.parseInt(tokens.nextToken())] = true;
		}
		//System.out.println(Arrays.toString(blackDay));
		
		System.out.println(resort(1,0));
	}
	
	static int resort(int day, int coupon) {
		if(day > N) return 0;
		int ans = cost[day][coupon];
		if(ans != 0) return ans;
		
		if(blackDay[day]) {
			ans = resort(day+1, coupon);
		}
		else {
			ans = Math.min(ans, resort(day+1, coupon)+10000);
			ans = Math.min(ans, resort(day+3, coupon+1)+25000);
			ans = Math.min(ans, resort(day+5, coupon+2)+37000);
			
			if(coupon >= 3) {
				ans = Math.min(ans, resort(day+1, coupon-3));
			}
		}
		return ans;
		
	}
	static String src = "50 10\r\n" + 
			"3 5 7 11 15 16 22 23 24 34";

}
