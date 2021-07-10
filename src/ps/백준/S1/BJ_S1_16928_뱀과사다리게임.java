package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_16928_뱀과사다리게임 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M, cnt;
	static int[] map = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String args[]) throws Exception {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		for (int n = 0; n < N + M; n++) {
			tokens = new StringTokenizer(input.readLine());
			map[Integer.parseInt(tokens.nextToken())] = Integer.parseInt(tokens.nextToken());
		}
		bfs(1);
		System.out.println(cnt);
	}

	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		visited[i] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int start = queue.poll();
				if(start == 100) return;
				for (int k = 1; k < 7; k++) {
					int next = start + k;
					if(next <= 100 && !visited[next]) {
						//들어와서
						
						//1. 뱀, 사다리가 있을경우
						if(map[next] != 0) {
							next = map[next];
							if(visited[next]) continue;
						}
						//2. 없을경우
						queue.offer(next);
						visited[next]=true;
					}
					
				}
			}
			cnt++;
		}

	}

	static String src = "3 7\r\n" + "32 62\r\n" + "42 68\r\n" + "12 98\r\n" + "95 13\r\n" + "97 25\r\n" + "93 37\r\n"
			+ "79 27\r\n" + "75 19\r\n" + "49 47\r\n" + "67 17";
}