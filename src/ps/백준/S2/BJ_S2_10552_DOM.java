package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_10552_DOM {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M, P, cnt;
	static int[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens =new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 사람수
		M = Integer.parseInt(tokens.nextToken()); // 채널수
		P = Integer.parseInt(tokens.nextToken()); // 초기 채널 번호 1 <= P <= M
		graph = new int[M+1];
		visited = new boolean[M+1];
		for (int n = 0; n < N; n++) {
			tokens =new StringTokenizer(input.readLine());
			int favorite = Integer.parseInt(tokens.nextToken());
			int hate = Integer.parseInt(tokens.nextToken());
			if(graph[hate] == 0) graph[hate] = favorite;
		}//입력완료
		
		dfs(P);
		System.out.println(cnt);
		
	}

//	private static void dfs1(int start) { //stack overflow
//		
//		for (int end = 1; end < M+1; end++) {
//			if(graph[start][end] == 1) {
//				if(end == P) {
//					System.out.println(-1);
//					System.exit(0);		
//				}
//				cnt++;
//				dfs1(end);
//				break;
//			}
//		}
//	}

	private static void dfs(int start) {
		if(visited[start]) {
			cnt = -1;
			return;
		}
		
		if(!visited[start] && graph[start] != 0){
			cnt++;
			visited[start] = true;
			dfs(graph[start]);
		}
	}
	
	static String src = "3 4 2\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"3 2";
}
