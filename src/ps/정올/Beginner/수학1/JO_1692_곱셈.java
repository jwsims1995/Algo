package ps.정올.Beginner.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1692_곱셈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int a, b, tmp;
	public static void main(String[] args) throws IOException {
		a = Integer.parseInt(input.readLine());
		b = Integer.parseInt(input.readLine());
		
		int sum  = 0;
		int num = 0;
		for (int i = 0; i < 3; i++) {
			num = a * (b % 10);
			b/=10;			
			sum+=num * Math.pow(10, i);
			System.out.println(num);
		}
		
		System.out.println(sum);
	}
}
