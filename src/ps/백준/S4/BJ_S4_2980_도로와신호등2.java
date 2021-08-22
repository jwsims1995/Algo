package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_2980_도로와신호등2 {
	static class Light{
		int red, green;
		
		public Light(int red, int green) {
			this.red = red;
			this.green = green;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, L;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		Light[] road = new Light[L+1];
		for(int n =0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int pos = Integer.parseInt(tokens.nextToken());
			int red = Integer.parseInt(tokens.nextToken());
			int green = Integer.parseInt(tokens.nextToken());
			road[pos] = new Light(red,green);
		}
		int now = 0;
		int time =0;
		while(now < L) {
			time++;
			now++;
			if(road[now] != null) { // 신호등을 만났다
				int check = time % (road[now].red + road[now].green);
				if(check <= road[now].red) { // 빨간불일 때 기다린 시간
					time += (road[now].red - check);
				}
			}
		}
		System.out.println(time);
	}

	static String src = "4 30\r\n" + 
			"7 13 5\r\n" + 
			"14 4 4\r\n" + 
			"15 3 10\r\n" + 
			"25 1 1";
}
