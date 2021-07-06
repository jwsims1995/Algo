package ps.백준.S1;

import java.io.*;
import java.util.*;


public class BJ_S1_1697_숨바꼭질 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, K, ans;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());

		bfs(N);
		System.out.println(ans);
	}

	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		int visited[] = new int[100001];
		Arrays.fill(visited, 0);
		while (!queue.isEmpty()) {
			int p = queue.poll();
			
			if(p == K) {
				ans = visited[p];
				return;
			}
			for (int i = 0; i < 3; i++) {
				int num = 0;
				// plus 1
				if (i == 0) {
					num = p - 1;
				}
				// minus 1
				else if (i == 1) {
					num = p + 1;
				}
				// mul 2
				else {
					num = p * 2;
				}
				
				if (isIn(num) && visited[num] == 0) {
					visited[num] = visited[p] + 1;
					queue.add(num);
				}
				
			}
		}
	}

	private static boolean isIn(int num) {
		return 0 <= num && num <= 100000;
	}

	static String src = "5 17";
}
