package ps.정올.Beginner.도형만들기2;

import java.io.*;
import java.util.*;

public class JO_1331_문자마름모 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
	static char[][] map;
	static int N, size;
	static char alpha = 'A';

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		size = 2 * N - 1;
		map = new char[size][size];
		 for(int i=0;i<size;++i) 
			 Arrays.fill(map[i],' ');
		int r = 0;
		int c = N - 1;
		map[r][c] = alpha++;
		for (int n = N - 1; n > 0; n--) {
			for (int i = 0; i < n; i++) {
				map[++r][--c] = alpha++;
				if (alpha > 'Z')
					alpha = 'A';
			}
			for (int i = 0; i < n; i++) {
				map[++r][++c] = alpha++;
				if (alpha > 'Z')
					alpha = 'A';
			}

			for (int i = 0; i < n; i++) {
				map[--r][++c] = alpha++;
				if (alpha > 'Z')
					alpha = 'A';
			}
			for (int i = 1; i < n; i++) {
				map[--r][--c] = alpha++;
				if (alpha > 'Z')
					alpha = 'A';
			}
			map[r][--c] = alpha++;

		}
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		} 
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				output.append(map[i][j]).append(" ");
			}
			output.append("\n");
		}
		System.out.print(output);
	}
}
