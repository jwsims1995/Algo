package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 6. 2.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class BJ_S4_10816_숫자카드2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static final int max_val = 20000001;
	static final int half_val = 10000000;
	static int[] card = new int[max_val];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=  new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			card[Integer.parseInt(tokens.nextToken()) + half_val]++;
		}
		
		M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int m = 0; m < M; m++) {
			output.append(card[Integer.parseInt(tokens.nextToken()) + half_val]).append(" ");
		}
		System.out.println(output);
	}
	static String src ="10\r\n" + 
			"6 3 2 10 10 10 -10 -10 7 3\r\n" + 
			"8\r\n" + 
			"10 9 -5 2 3 4 5 -10";
}
