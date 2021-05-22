package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B1_2750_수정렬하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int res[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		res = new int[N];
		for (int n = 0; n < N; n++) {
			res[n] = Integer.parseInt(input.readLine());
		}
		Arrays.sort(res);
		for (int n = 0; n < N; n++) {
			System.out.println(res[n]);
		}
	}
}
