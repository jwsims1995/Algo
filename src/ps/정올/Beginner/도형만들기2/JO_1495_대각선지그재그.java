package ps.정올.Beginner.도형만들기2;

import java.io.*;
import java.util.*;

public class JO_1495_대각선지그재그 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, num;
	static int[][] deltas = { { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, -1 } };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N+1][N+1];
		int r = 0;
		int c = 0;
		boolean goUp = false;
		for (int n = 0; n < N; n++) {
			for (int i = 0; i < n; i++) {
				if (!goUp)
					map[r++][c--] = ++num;
				else
					map[r--][c++] = ++num;
			}
			if (!goUp) {
				map[r++][c] = ++num;
				goUp = !goUp;
			}

			else {
				map[r][c++] = ++num;
				goUp = !goUp;
			}
		}
		
		if(N%2==1) {
			r--;
			c++;			
		}else {
			r++;
			c--;
		}
		
		for (int n = N - 1; n > 0; n--) {
			for (int i = 0; i < n-1; i++) {
				if (!goUp)
					map[r++][c--] = ++num;
				else
					map[r--][c++] = ++num;
			}
			if (!goUp) {
				map[r][c++] = ++num;
				goUp = !goUp;
			}

			else {
				map[r++][c] = ++num;
				goUp = !goUp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				output.append(map[i][j]).append(" ");
			}
			output.append("\n");
		}
		System.out.print(output);
	}

}
