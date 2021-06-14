package ps.정올.Beginner.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1901_소수구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, num;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		for (int n = 0; n < N; n++) {
			num = Integer.parseInt(input.readLine());
			int up = 0;
			int down = 0;
			while(true) {
				if(isPrime(num + up))
					break;
				up++;
			}
			while(true) {
				if(isPrime(num - down))
					break;
				down++;
			}
			if(up+down ==0) {
				output.append(num).append("\n");
				continue;
			}
			if(up == down)output.append(num-down).append(" ").append(num+up).append("\n");
			else {
				if(Math.min(up, down) == down) {
					output.append(num - down).append("\n");
				}else {
					output.append(num + up).append("\n");
				}
				
			}
			
		}
		System.out.println(output);
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i*i <= num; i++) {
			if(num%i==0)return false;
		}
		return true;
	}
	
}
