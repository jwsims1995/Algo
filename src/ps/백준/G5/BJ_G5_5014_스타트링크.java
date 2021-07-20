package ps.백준.G5;

import java.io.*;
import java.util.*;

public class BJ_G5_5014_스타트링크 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int F, S, G, U, D, cnt;
	static boolean[] visited;
	static boolean canGo;
	static int[] deltas = new int[2];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		F = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		G= Integer.parseInt(tokens.nextToken());
		U = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		
		deltas[0] = U;
		deltas[1] = -D;
		
		if(S==G) {
			System.out.println(cnt);
			System.exit(0);
		}
		bfs();
		
		System.out.println(canGo?++cnt:"use the stairs");
	}
	private static void bfs() {
		Queue<Integer> queue =new LinkedList<>();
		visited = new boolean[F+1];
		queue.add(S);
		visited[S] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int p = queue.poll();
				for (int d = 0; d < 2; d++) {
					int next = p + deltas[d];
					if(next >= 1 && next <= F && !visited[next]) {
						if(next == G) {
							canGo = true;
							return; //목적지 도착시 return
						}
						
						visited[next] = true;
						queue.add(next);
						
					}
				}
			}
			cnt++;
		}
		
	}
	static String src = "1000000 1 1000000 1 1";
}

