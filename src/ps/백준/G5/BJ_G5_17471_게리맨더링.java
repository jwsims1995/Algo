package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_17471_게리맨더링 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] pops;
	static boolean[][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			pops[n] = Integer.parseInt(tokens.nextToken());
		}
		
		graph = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int cnt = Integer.parseInt(tokens.nextToken());
			for (int c = 0; c < cnt; c++) {
				int to = Integer.parseInt(tokens.nextToken()) -1; //0번부터 사용중...
				graph[n][to] = true;							// 두 노드는 연결되어 있다.
				
			}
		}// 그래프 구성 끝
		// 부분 집합 - 여집합의 개념을 사용할꺼니까...반틈만 구해도 충분~
		for (int i = 1; i < N/2; i++) {
			combination(i, new boolean[N], 0);
		}
	}
	
	static void combination(int toChoose , boolean[] choosed, int start){
		if(toChoose==0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		for (int i = start; i < N; i++) {
			choosed[i] = true;
			combination(toChoose-1, choosed, i+1);
			choosed[i] = false;
		}
	}	
	
	static void dfs(int i, boolena[] )
	
	static String src = "6\n"
			+ "5 2 3 4 1 2\n"
			+ "2 2 4\n"
			+ "4 1 3 6 5\n"
			+ "2 4 2\n"
			+ "2 1 3\n"
			+ "1 2\n"
			+ "1 2";
}
