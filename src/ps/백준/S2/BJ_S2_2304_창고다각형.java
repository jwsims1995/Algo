package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_2304_창고다각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] pos;
	static int[] height;
	static int[] width;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		pos = new int[N];
		height = new int[1001];
		int sum=0;
		int max = 0;
		int roof=0;
		int maxIdx=0;
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			pos[n] = Integer.parseInt(tokens.nextToken());
			height[pos[n]] = Integer.parseInt(tokens.nextToken());
			if(max < height[pos[n]]) {
				max = height[pos[n]];
				maxIdx = pos[n];
			}
			
		}//max값 설정
		
		for (int n = 1; n <= maxIdx; n++) {
			if(roof < height[n]) {
				roof = height[n];
			}
			sum+=roof;
		}//max까지 올라감
		
		roof = 0; //roof초기화
		
		for (int i = 1000; i > maxIdx; i--) {
			if(roof < height[i]) {
				roof = height[i];
			}
			sum+=roof;
		}//뒤에서부터 max까지
		System.out.println(sum);
	}

	static String src = "7\r\n" + 
			"2 4\r\n" + 
			"11 4\r\n" + 
			"15 8\r\n" + 
			"4 6\r\n" + 
			"5 3\r\n" + 
			"8 10\r\n" + 
			"13 6";
}
