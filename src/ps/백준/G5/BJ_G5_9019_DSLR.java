package ps.백준.G5;

import java.io.*;
import java.util.*;

public class BJ_G5_9019_DSLR {
	static class Info {
		int idx;
		String spell;

		public Info(int idx, String spell) {
			this.idx = idx;
			this.spell = spell;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, A, B, cnt;
	static boolean[] visited;
	static String ans;
	static char[] deltas = { 'D', 'S', 'L', 'R' }; // D S L R

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			A = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			// A->B

			bfs();
			
			output.append(ans).append("\n");
		}
		System.out.println(output);
	}

	private static void bfs() {
		Queue<Info> queue = new LinkedList<>();
		visited = new boolean[10000];
		queue.add(new Info(A, ""));
		while (!queue.isEmpty()) {
			Info p = queue.poll();
			if (p.idx == B) {
				ans = p.spell;
				return;
			}
			int deltaSize = deltas.length;
			for (int d = 0; d < deltaSize; d++) {

				int np = 0;
				char spell = deltas[d];

				switch (spell) {
				case 'D': {
					np = 2 * p.idx % 10000;
					break;
				}
				case 'S': {
					np = p.idx - 1;
					if (np < 0)
						np += 10000;
					break;
				}
				case 'L': {
					int d1 = p.idx / 1000;
					int d2 = p.idx / 100 % 10;
					int d3 = p.idx / 10 % 10;
					int d4 = p.idx % 10;

					np = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
					break;
				}
				case 'R':
					int d1 = p.idx / 1000;
					int d2 = p.idx / 100 % 10;
					int d3 = p.idx / 10 % 10;
					int d4 = p.idx % 10;

					np = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
					break;
				}
//						System.out.println(np);
				if (!visited[np]) {
					visited[np] = true;
					queue.add(new Info(np, p.spell + spell));

				}
			}

		}

	}

	static String src = "3\r\n" + "1234 3412\r\n" + "1000 1\r\n" + "1 16";
}
