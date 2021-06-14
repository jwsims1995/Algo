package ps.정올.Beginner.도형만들기2;

import java.io.*;
import java.util.*;

public class JO_2074_홀수마방진 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, num,r,c;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());//2~100 홀수
		map = new int[N][N];
		r = 0;
		c = N/2;
		map[r][c] = ++num;
		while(num < N*N) {
			if(num % N == 0) {
				r = r + 1;
				check();
				map[r][c] = ++num;
			}else {
				r=r-1;
				c=c-1;
				check();
				map[r][c] = ++num;
			}
		}
		

		//출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				output.append(map[i][j]).append(" ");
			}
			output.append("\n");
		}
		System.out.print(output);
	}

	static void check() {
		if(r < 0)r+=N;
		if(c < 0)c+=N;
		if(r > N)r-=N;
		if(c > N)c-=N;
	}
}
