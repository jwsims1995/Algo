package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B1_3985_롤케이크 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int L = Integer.parseInt(input.readLine());
		int N = Integer.parseInt(input.readLine());
		int[] cake = new int[L];
		int[] start = new int[N];
		int[] end = new int[N];
		int expectMax = 0;
		int ans1 = 0;
		
		int max = 0;
		int ans2 = 0;
		
		int[] cnt = new int[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			start[n] = Integer.parseInt(tokens.nextToken());
			end[n] = Integer.parseInt(tokens.nextToken());
			if(expectMax < end[n] - start[n]) {
				expectMax = end[n] - start[n];
				ans1= n+1;
			}
			//기대 번호 완료

			for (int i = start[n]; i <= end[n]; i++) {
				if(cake[i-1] == 0) {
					cake[i-1] = n+1;
					cnt[n]++;
				}
			}
			if(max < cnt[n]) {
				max = cnt[n];
				ans2 = n+1;				
			}
		}

		System.out.println(ans1);
		System.out.println(ans2);
	}
}
