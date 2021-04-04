package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B2_2231_분해합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		for (int n = 1; n <= N; n++) {
			int sum = 0;
			if(1<=n && n<10) {
				sum = n+n%10;	//일의자리수
				if(sum == N) {
					ans = n;
					break;
				}
			}
			else if(11<=n && n<100) {
				sum = n+n%10+n/10; //일의자리수 + 십의자리수
				if(sum == N) {
					ans = n;
					break;
				}
			}
			else if(101<= n && n <1000) {
				sum = n+n%10+(n/10)%10 + n/100; //일의자리수 + 십의자리수 + 백의자리수
				if(sum == N) {
					ans = n;
					break;
				}
			}
			else if (1001 <=n && n<10000) {
				sum = n+n%10+(n/10)%10 + (n/100)%10 + n/1000; //일의자리수 + 십의자리수 + 백의자리수 + 천의자리수
				if(sum == N) {
					ans = n;
					break;
				}
			}
			else if(10001 <= n && n <100000) {
				sum = n+n%10+(n/10)%10 + (n/100)%10 + (n/1000)%10 + n/10000; //일의자리수 + 십의자리수 + 백의자리수 + 천의자리수 +만의자리수
				if(sum == N) {
					ans = n;
					break;
				}
			}
			else if(100001 <= n && n < 1000000) {
				sum = n+n%10+(n/10)%10 + (n/100)%10 + (n/1000)%10 + (n/10000)%10 + n/100000; //일의자리수 + 십의자리수 + 백의자리수 + 천의자리수 +만의자리수 + 십만자리수
				if(sum == N) {
					ans = n;
					break;
				}
			}
		}
		System.out.println(ans);
	}
	static String src = "216";
}
