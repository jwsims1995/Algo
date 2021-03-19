package ps.백준.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
/**
 * @since 2021. 3. 19.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class BJ_10250_B3_ACM호텔 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, H, W, N;
	public static void main(String[] args) throws IOException {
		input  = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			H = Integer.parseInt(tokens.nextToken()); // 층수
			W = Integer.parseInt(tokens.nextToken()); // 각 층 방 수
			N = Integer.parseInt(tokens.nextToken()); // 몇 번째 손님
			
			int front;
			if(N%H == 0) front= H *100;
			else front = N%H *100; // 10 % 6  앞자리
			
			int back;
			if(N%H == 0) back = N/H;
			else back = N/H+1;
			
			output.append(front+back + "\n");
			
		}
		System.out.println(output);

	}
	static String src = "2\r\n" + 
			"6 12 10\r\n" + 
			"30 50 72";
}
