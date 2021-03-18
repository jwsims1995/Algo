package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B1_2851_슈퍼마리오 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int[] sum = new int[10];
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int preSum = 0;
		for (int i = 0; i < 10; i++) {
			int mushroom = Integer.parseInt(input.readLine());
			sum[i] = preSum + mushroom;
			if(sum[i] >= 100) {
				System.out.println(compare(sum[i], preSum));
				return;
			}
			preSum += mushroom;
		}
		System.out.println(preSum);
	}
	private static int compare(int i, int preSum) {
		return Math.abs(i-100) > Math.abs(100 - preSum)? preSum : i;
	}
}
