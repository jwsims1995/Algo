package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_14567_선수과목 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static boolean[][] visited;
	static boolean[][] subject;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 과목수
		M = Integer.parseInt(tokens.nextToken()); // 선수조건 수
		subject = new boolean[N][N];
		visited = new boolean[N][N];
		
		for (int n = 0; n < M; n++) {
			tokens = new StringTokenizer(input.readLine());
			int pre = Integer.parseInt(tokens.nextToken());
			int now = Integer.parseInt(tokens.nextToken());
			subject[pre][now] = true;
		}
		
		
		for (int now = 1; now <= N; now++) {
			dfs(now, 0, 0);
			output.append(" ");
		}
		System.out.println(output);
	}
	
	

	private static void dfs(int now, int pre, int cnt) {
		if(visited[pre][now]) return;
		
		for (int p = 1; p < N; p++) {
			if(!visited[p][now] && subject[p][now]) {
				dfs(p,0,cnt+1);
			}
		}
	}



	private static String src = "3 2\n" + 
			"2 3\n" + 
			"1 2"; //1 2 3
}
