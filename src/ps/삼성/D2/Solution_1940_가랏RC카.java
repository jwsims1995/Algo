package ps.삼성.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 8.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class Solution_1940_가랏RC카 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, dist, num, speed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			dist = 0;
			N = Integer.parseInt(input.readLine());
			int acc = 0;
			int speed =0;
			for (int n = 0; n < N; n++) {
				String line = input.readLine();
				if (!line.equals("0")) {
					tokens = new StringTokenizer(line);
					num = Integer.parseInt(tokens.nextToken());
					acc = Integer.parseInt(tokens.nextToken());
					if (num == 1) {
						speed += acc;
					} else if (num == 2) {
						speed -= acc;
						if (speed < 0)
							speed = 0;
					}
				}
				dist += speed;
			}
			output.append("#" + t + " " + dist + "\n");
		}
		System.out.println(output);
	}
}
