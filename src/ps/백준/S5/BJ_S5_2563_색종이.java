package ps.백준.S5;
/**
 * @since 2021. 2. 9.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S5_2563_색종이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int row, col, answer;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new boolean[100][100];
		int width = 0;
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			row = Integer.parseInt(tokens.nextToken());
			col = Integer.parseInt(tokens.nextToken());
			for (int r = row; r < row + 10; r++) {
				for (int c = col; c < col + 10; c++) {
					if (map[r][c])
						continue;
					map[r][c] = true;
					width++;
				}
			}

		}
		System.out.println(width);
	}
}
