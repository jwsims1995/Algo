package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_2003_수들의합2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, ans;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr= new int[N+1];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(tokens.nextToken());
		}
		//System.out.println(Arrays.toString(arr));
		int start=  0;
		int end = 0;
		int partial_sum = 0;
		
		while(end<=N) {
			if(partial_sum == M) {
				ans++;
			}
			if(partial_sum > M) partial_sum-=arr[start++];
			else partial_sum += arr[end++];
		}
		System.out.println(ans);
	}
	static String src = "10 5\r\n" + 
			"1 2 3 4 2 5 3 1 1 2"; //3
}