package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_2559_수열2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		arr=  new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(tokens.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		int sum;
		for (int i = 0; i <= N-K; i++) {
			sum = 0;
			for (int j = i; j < i+K; j++) {
				sum+=arr[j];
			}
			if(max < sum) max = sum;
		}
		
		System.out.println(max);
	}
	static String src = "2 2\r\n" + 
			"2 1"; //21
}