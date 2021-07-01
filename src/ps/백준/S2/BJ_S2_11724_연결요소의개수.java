package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S2_11724_연결요소의개수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M, cnt;
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		graph = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			graph[start][end] = true;
			graph[end][start] = true;
		}
		
		for(int start=1; start<=N; start++) {
			if(!visited[start]) {
				dfs(start);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	private static void dfs(int start) {
		if(visited[start]) {
			return;
		}
		visited[start] = true;
		for (int n = 1; n < graph.length; n++) {
			if(graph[start][n]) {
				dfs(n);
			}
		}
	}



	static String src = "6 8\n" + 
			"1 2\n" + 
			"2 5\n" + 
			"5 1\n" + 
			"3 4\n" + 
			"4 6\n" + 
			"5 4\n" + 
			"2 4\n" + 
			"2 3";//2
}
