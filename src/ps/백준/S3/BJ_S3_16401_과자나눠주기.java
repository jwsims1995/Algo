package ps.백준.S3;

import java.io.*;
import java.util.*;

public class BJ_S3_16401_과자나눠주기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M, N;
	static int ans;
	static int[] snack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken()); //조카수
		N = Integer.parseInt(tokens.nextToken()); //과자갯수
		snack = new int[M];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0;n<N;n++) {
			snack[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(snack);
		
		int start = 1;
		int end = snack[N-1];
		while(start <= end) {
			int mid = (start + end) / 2;
			int cnt = 0;
			for(int n=0; n<N;n++) {
				cnt+=snack[n]/mid;
			}
			if(cnt>=M) {
				end = mid+1;
				ans = mid;
			}else { // cnt < M
				start = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static String src = "3 10\n" + 
			"1 2 3 4 5 6 7 8 9 10";
}
