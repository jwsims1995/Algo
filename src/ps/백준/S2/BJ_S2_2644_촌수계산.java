package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_2644_촌수계산 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, a, b, ans;
	static boolean[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(input.readLine());
		graph = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		tokens = new StringTokenizer(input.readLine());
		a = Integer.parseInt(tokens.nextToken());
		b = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(input.readLine());
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			graph[r][c] = true;
			graph[c][r] = true;
		}//입력완료
//		for (boolean[] row : graph) {
//			System.out.println(Arrays.toString(row));
//		}//입력확인
		
		//bfs(a);
		
		dfs(a, 0);
		
		if(ans==0)System.out.println(-1);
		else System.out.println(ans);
		
	}
	private static void dfs(int a, int step) {
		if(a == b) {
			ans = step;
			return;
		}
		visited[a] = true;
		for (int n = 1; n <= N; n++) {
			if(!visited[n] && graph[a][n]) {
				dfs(n, step+1);
			}
		}
	}
	private static void bfs(int a) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(a);
		visited[a] = true;
		int step = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				int p = queue.poll();
				if(p == b) {
					ans = step;
					return;
				}
				for (int n = 1; n <= N; n++) {
					if(!visited[n] && graph[p][n]) {
						queue.offer(n);
						visited[n] = true;
					}
				}
			}
			step++;
		}
		ans = -1;
	}
	static String src = "9\r\n" + 
			"7 3\r\n" + 
			"7\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"2 7\r\n" + 
			"2 8\r\n" + 
			"2 9\r\n" + 
			"4 5\r\n" + 
			"4 6";
}
