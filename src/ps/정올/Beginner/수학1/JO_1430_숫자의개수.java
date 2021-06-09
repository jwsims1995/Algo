package ps.정올.Beginner.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1430_숫자의개수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int a, b, c, mul; // 100<= ㅇ  <1000 
	static int[] num = new int[10];
	public static void main(String[] args) throws IOException {
		a = Integer.parseInt(input.readLine());
		b = Integer.parseInt(input.readLine());
		c =Integer.parseInt(input.readLine());
		mul = a*b*c;
		String str = String.valueOf(mul);
		char[] c = str.toCharArray();
		
		for (int i = 0; i < c.length; i++) {
			num[mul%10]++;
			mul/=10;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(num[i]);
		}
	}
}
