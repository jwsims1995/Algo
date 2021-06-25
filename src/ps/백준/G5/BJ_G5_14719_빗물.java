package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_14719_빗물 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int H, W;
	static int[] height;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		H = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		height = new int[W];
		tokens = new StringTokenizer(input.readLine());
		for (int w = 0; w < W; w++) {
			height[w] = Integer.parseInt(tokens.nextToken());
		}//입력완료
		
		boolean getRain = false;

		int start = 0;
		int rainSum  =0;
		for (int w = 0; w < W-1; w++) {		
			//오르다가 내려가는 순간
			if(!getRain && height[w] > height[w+1]) {
				getRain = true;
				// 그전에꺼 계산
				if(height[start] < height[w]) {
					int idx = start;
					while(height[start] >= height[idx]) {
						rainSum += (height[start] - height[idx++]);
					}
				}
				else {
					for (int i = start; i <= w; i++) {
						rainSum += (height[start] - height[i]);
					}					
				}
				start= w; //시작하는 idx 저장				
			}
			else if(height[w] < height[w+1]) getRain = false;
		}
		
		System.out.println(rainSum);
	}
	
	

	private static String src = "4 4\r\n" + 
			"3 0 1 4"; //5
}
