package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B2_13458_시험감독 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static long B,C,ans,total;
	static long[] A;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		A = new long[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		B = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		//입력완료
		
		for (int n = 0; n < N; n++) {
			total = A[n]-B;
			if(total<0) {
				ans+=1;
				continue;
			}
			ans += total/C + 1;
			
			if(total%C > 0) ans++;
		}
		System.out.println(ans);
	}
}
