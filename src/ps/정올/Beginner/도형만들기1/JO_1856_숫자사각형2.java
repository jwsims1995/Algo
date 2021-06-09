package ps.정올.Beginner.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1856_숫자사각형2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int H, W;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		H = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		
		for (int h = 0; h < H; h++) {
			if(h%2==0) {
				for (int w = 1; w <= W; w++) {
					System.out.printf("%d ",w + h*W);
				}
				System.out.println();				
			}
			else {
				for (int w = W; w >= 1; w--) {
					System.out.printf("%d ",w + h*W);
				}
				System.out.println();	
			}
			
		}
	}
}
