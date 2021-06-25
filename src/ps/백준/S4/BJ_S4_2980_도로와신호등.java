package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S4_2980_도로와신호등 {
	static class Light {
		int r, g;

		public Light(int r, int g) {
			super();
			this.r = r;
			this.g = g;
		}

	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, L; // 갯수, 도로길이
	static int D, R, G; // D : 신호등위치
	static int[][] map;
	static int time, idx;
	static boolean isRed;
	static Light[] light;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		light = new Light[L+1];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			D = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			G = Integer.parseInt(tokens.nextToken());
			light[D] = new Light(R, G);
		} // 입력완료
		
		
		while(idx < L) {
			time++;
			idx++;
			
			if(light[idx] != null) { //신호등이 있다면
				int cnt = time %( light[idx].r + light[idx].r );
				
				if(cnt <= light[idx].r) time+= (light[idx].r - cnt);
			}
		}
		

		System.out.println(time);

	}

	static String src = "2 10\r\n" + "3 5 5\r\n" + "5 2 2";
}
