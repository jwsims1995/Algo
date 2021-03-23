package ps.백준.B1;
/**
 * @since 2021. 3. 24.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_4344_평균은넘겠지 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int C, N;
	static int[] score;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		C = Integer.parseInt(input.readLine());
		for (int c = 0; c < C; c++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			score = new int[N];
			int sum = 0;
			int avg = 0;
			double cnt = 0;
			for (int n = 0; n < N; n++) {
				int t = Integer.parseInt(tokens.nextToken());
				sum+= t;
				score[n] =t;
			}
			avg = sum/N;
			for (int n = 0; n < N; n++) {
				if(score[n] > avg) cnt++;
			}
			double ans = cnt * 100 / N;
			System.out.printf("%.3f%%\n", ans);
		}
	}

	static String src = "5\r\n" + 
			"5 50 50 70 80 100\r\n" + 
			"7 100 95 90 80 70 60 50\r\n" + 
			"3 70 90 80\r\n" + 
			"3 70 90 81\r\n" + 
			"9 100 99 98 97 96 95 94 93 91";
}
