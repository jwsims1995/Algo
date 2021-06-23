package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_2491_수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(tokens.nextToken());
		}
		//입력완료
		//System.out.println(Arrays.toString(arr));//입력확인
		
		if(N==1) {
			System.out.println(1);
			System.exit(0);
		}
			
			
		int ascMax = 0;
		int descMax = 0;
		//오름차순
		int cnt = 1;
		for (int n = 1; n < N; n++) {
			if(arr[n-1] <= arr[n]) {
				cnt++;
				if(ascMax < cnt) ascMax = cnt;
			}else {
				cnt = 1;
			}
		}
		//System.out.println(ascMax);
		//내림차순
		cnt = 1;
		for (int n = 1; n < N; n++) {
			if(arr[n-1] >= arr[n]) {
				cnt++;
				if(descMax < cnt) descMax = cnt;
			}else {
				cnt = 1;
			}
		}
		//System.out.println(descMax);

		//출력
		System.out.println(Math.max(ascMax, descMax));
	}
	static String src = "1\r\n" + 
			"4";
}
