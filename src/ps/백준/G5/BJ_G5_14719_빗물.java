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
	static int H, W, total;
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
		
		for (int w = 1; w < W-1; w++) {
			int left =0 ;
			int right = 0;
			for (int front = 0 ; front<w ; front++) {
				left= Math.max(height[front], left);
			}
			for(int back = w; back<W; back++) {
				right = Math.max(height[back], right);
			}
			int diff = Math.min(right, left);
			if(height[w] < right && height[w] < left) total+= diff - height[w]; 
		}
		System.out.println(total);
	}
	
	

	private static String src = "4 8\n" + 
			"3 1 2 3 4 1 1 2"; //5
}
