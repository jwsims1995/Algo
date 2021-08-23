package ps.삼성.D3;

import java.io.*;
import java.util.*;

public class Solution_7964_부먹왕국의차원관문 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 0;
			tokens = new StringTokenizer(input.readLine());
			int cities = Integer.parseInt(tokens.nextToken());
			int limit = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(input.readLine());

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < cities; i++) {
				queue.add(Integer.parseInt(tokens.nextToken()));
			}
			// 입력
			System.out.println(queue);

			while (!queue.isEmpty()) {
				if (queue.peek() == 0) { // 0이면 차원관문 필요해
					ans++;

					for (int l = 0; l < limit; l++) {
						if(!queue.isEmpty() && queue.peek() ==0)
							queue.poll();
					}
				}

				else { // queue.peek == 1;일때
					queue.poll();
					for (int l = 0; l < limit-1; l++) {
						if(!queue.isEmpty() && queue.peek()==0)
							queue.poll();
					}
				}

			}

			output.append("#").append(t).append(" ").append(ans).append("\n");

		}
		System.out.println(output);
	}

	static String src = "3\n" + "6 2\n" + "1 0 0 0 0 1\n" + "9 2\n" + "0 0 1 0 1 0 0 0 0 1\n" + "10 1\n"
			+ "0 0 0 0 0 0 0 0 0 0";
}
