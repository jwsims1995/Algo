package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_10815_숫자카드 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[] own = new int[20000000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			own[Integer.parseInt(tokens.nextToken())+10000000]++;
		}
		M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int m = 0; m < M; m++) {
			int idx = Integer.parseInt(tokens.nextToken())+10000000;
			if(own[idx] > 0) output.append(1).append(" ");
			else output.append(0).append(" ");
		}
		System.out.println(output);
	}
}
