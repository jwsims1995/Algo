package ps.정올.Beginner.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1438_색종이_초 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T ,R, C, ans;
	static boolean[][] map = new boolean[100][100];
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine()); // 1<= T <= 100
		int rMax=0, rMin=100, cMax=0, cMin=100;
		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			rMax = Math.max(rMax, R);
			rMin = Math.min(rMin, R);
			cMax = Math.max(cMax, C);
			cMin = Math.min(cMin, C);
			
		}
		ans += 2*(rMax+10 - rMin);
		ans += 2*(cMax+10 - cMin);
		
		if(rMin+10 < rMax && cMin+10 < cMax) {
			ans += 2*(rMax - (rMin+10));
			ans += 2*(cMax - (cMin+10));				
		}
		
		System.out.println(ans);
	}
}
