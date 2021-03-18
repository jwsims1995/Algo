package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B1_2839_설탕배달 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		int cnt = 0;
		
		while(true) {
			if(N % 5 == 0) {
				System.out.println(N / 5 + cnt);
				break;
			}
			else if(N <= 0) {
				System.out.println(-1);
				break;
			}
			N -= 3;
			cnt++;
		}
	}
}
