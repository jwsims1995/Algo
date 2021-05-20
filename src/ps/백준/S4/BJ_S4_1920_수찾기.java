package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_1920_수찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, num, flag;
	static int[] A;
	static int M;
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		A = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(tokens.nextToken());
		}
		M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int m = 0; m < M; m++) {
			flag= 0;
			num = Integer.parseInt(tokens.nextToken());
			
			for (int n = 0; n < N; n++) {
				if(A[n] == num) {
					flag = 1;
					break;
				}
			}
			output.append(flag + "\n");
		}
		System.out.println(output);
	}
}
