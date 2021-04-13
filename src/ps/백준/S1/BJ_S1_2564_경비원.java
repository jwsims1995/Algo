package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2564_경비원 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int R, C, N, ans;
	public static void main(String[] args) throws IOException {
		input =new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(input.readLine());
		int[] dir = new int[N+1];
		int[] dist = new int[N+1];	//마지막은 내꺼
		
		for (int n = 0; n <= N; n++) {
			tokens = new StringTokenizer(input.readLine());
			dir[n] = Integer.parseInt(tokens.nextToken());
			dist[n] = Integer.parseInt(tokens.nextToken());
		}
		
		//입력완료
		
		for (int n = 0; n <= N; n++) {
			switch(dir[n]) {
			case 1: 
				dist[n] = dist[n];
				break;
			case 2: 
				dist[n] = -(C + dist[n]);
				break;
			case 3: 
				dist[n] = -dist[n];
				break;
			case 4:
				dist[n] = R + dist[n];
			}
		}
	
		for (int n = 0; n < N; n++) {
			ans = Math.abs(dist[N] - dist[n]) <= R+C ? ans+Math.abs(dist[N] - dist[n]) : ans+ (2*(R+C) - (Math.abs(dist[N] - dist[n]))); 
		}
		
		System.out.println(ans);
	}

	static String src = "10 5\r\n" + 
			"2\r\n" + 
			"1 4\r\n" + 
			"4 1\r\n" + 
			"2 3";
}
