package ps.백준.S3;

/**
 * @since 2021. 2. 14.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_S3_11659_구간합구하기4 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[] num;
	static int[] sum;
	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		num  = new int[N];
		sum  = new int[N+1];
		
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(tokens.nextToken());
		}
		for (int n = 1; n <= N; n++) {
			sum[n] = sum[n-1] + num[n-1];
		}
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			
			int startIdx = Integer.parseInt(tokens.nextToken());
			int endIdx = Integer.parseInt(tokens.nextToken());
			
			output.append(sum[endIdx] - sum[startIdx-1]).append("\n");
			
		}//입력완료
		System.out.println(output);
	}
	static String src ="5 3\n" + 
			"5 4 3 2 1\n" + 
			"1 3\n" + 
			"2 4\n" + 
			"5 5";
}