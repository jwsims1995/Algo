package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_구간합구하기5 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		int[][] sum = new int[N][N];

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		} // map입력

		for (int r = 0; r < N; r++) {
			sum[r][0] = map[r][0];
			for (int c = 1; c < N; c++) {
				sum[r][c] = sum[r][c - 1] + map[r][c];
			}
		} // 구간합 구하기

//		for (int[] row : sum) {
//			System.out.println(Arrays.toString(row));
//		}

		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int startR = Integer.parseInt(tokens.nextToken()) - 1;
			int startC = Integer.parseInt(tokens.nextToken()) - 1;
			int endR = Integer.parseInt(tokens.nextToken()) - 1;
			int endC = Integer.parseInt(tokens.nextToken()) - 1;
			int ans = 0;

			for (int r = startR; r <= endR; r++) {
				if (startC == 0) {
					ans += sum[r][endC];
					continue;
				}
				ans += sum[r][endC] - sum[r][startC - 1];
			}
			output.append(ans).append("\n");
		}
		System.out.println(output);

	}

	static String src = "2 4\r\n" + "1 2\r\n" + "3 4\r\n" + "1 1 1 1\r\n" + "1 2 1 2\r\n" + "2 1 2 1\r\n" + "2 2 2 2";
}
