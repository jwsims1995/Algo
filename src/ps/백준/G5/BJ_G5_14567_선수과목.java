package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_14567_선수과목 {
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
		
		int maxHeight = height[0];
		int total = 0;
		for (int w = 0; w < W; w++) {
			if(height[w] > maxHeight) {
				maxHeight=height[w];
				continue;
			}
			
			if(height[w] < maxHeight) {
				total += maxHeight - height[w];
			}
		}
		
		System.out.println(total);
	}
	
	

	private static String src = "4 8\n" + 
			"3 1 2 3 4 1 1 2"; //5
}
