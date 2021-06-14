package ps.정올.Beginner.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2811_소수와합성수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr = new int[5];
	static int num;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < arr.length; n++) {
			num  = Integer.parseInt(tokens.nextToken());
			if(isPrime()) {
				System.out.println("prime number");
			}
			else {
				if(num==1)System.out.println("number one");
				else System.out.println("composite number");
			}
		}
	}
	private static boolean isPrime() {
		if(num == 1) return false;
				
		for (int n = 2; n <= num/n; n++) {
			if(num % n == 0)return false;
		}
		return true;
	}
}
