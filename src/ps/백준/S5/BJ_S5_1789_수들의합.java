package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S5_1789_수들의합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static long S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		S = Long.parseLong(input.readLine());
		long sum = 0;
		int ans = 0;
		int idx = 1;
		while (S > sum) {
			sum += idx++;
		}
		sum -= (idx - 1);
		if (idx - 1 > S - sum) {
			// 한번 더빼
			ans = idx - 2;
		} else {
			ans = idx - 1;

		}
		System.out.println(ans);
	}
}
