package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1260_DFS와BFS {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N,M,V;
	static boolean[][] graph;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());
		graph = new boolean[N+1][N+1];
		int from = 0;
		int to = 0;
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			from = Integer.parseInt(tokens.nextToken());
			to = Integer.parseInt(tokens.nextToken());
			graph[from][to] = true;
			graph[to][from] = true;
		}// 입력완료
//		for (boolean[] row : graph) {
//			System.out.println(Arrays.toString(row));
//		}
		visit = new boolean[N+1];
		dfs(V);
		output.append("\n");
		Arrays.fill(visit, false);
		bfs(V);
		System.out.println(output);
	}
	static void dfs(int start) {
		visit[start] = true;
		output.append(start + " ");
		for (int i = 1; i < visit.length; i++) {
			if(!visit[i] && graph[start][i]) {
				dfs(i);
			}
		}
		//visit[start] = false;
	}
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visit[start] = true;
		while(!queue.isEmpty()) {
			int q = queue.poll();
			output.append(q + " ");
			for (int i =1; i < graph.length; i++) {
				if(graph[q][i] && !visit[i]) {
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
	static String src = "4 5 1\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"2 4\r\n" + 
			"3 4";
}
