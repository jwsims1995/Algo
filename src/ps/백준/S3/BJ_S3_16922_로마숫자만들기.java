package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_16922_로마숫자만들기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		Combination(N, new int[4], 0);
		System.out.println(cnt);
	}
	private static void Combination(int toChoose, int[] choosed, int idx) {
		if(toChoose == 0) {
			cnt++;
			return;
		}
		for (int i = idx; i < choosed.length; i++) {
			Combination(toChoose, choosed, idx+1);
		}
	}
}
