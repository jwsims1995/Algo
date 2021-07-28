package ps.백준.S3;

import java.io.*;
import java.util.*;

public class BJ_S3_2805_나무자르기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, ans;
	static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // N개 나무
		M = Integer.parseInt(tokens.nextToken()); // M만큼 들고감
		num = new int[N+1];
		tokens =new StringTokenizer(input.readLine());
		int max = 0;
		int min = 0;
		for (int n = 1; n <= N; n++) {
			num[n] = Integer.parseInt(tokens.nextToken());
			max = Math.max(max, num[n]);
		}
		

		
		while(min<=max) {
			int mid = (max + min)/2;
			long sum = 0;
			
			System.out.println("mid: "+mid);
			for (int n = 1; n <= N; n++) {
				if(num[n]>mid)
					sum+= num[n]-mid; 
			}
			System.out.println(sum);
			if(sum >= M) {
				min = mid+1;
				ans = mid;
			}
			else {
				max = mid-1;
			}
			
		}
		System.out.println(ans);
	}

	static String src = "5 20\n" + 
			"4 42 40 26 46";
}
