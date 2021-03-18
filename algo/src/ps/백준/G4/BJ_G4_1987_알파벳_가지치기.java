package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 18.
 * @author Jaewon
 * @see https://www.acmicpc.net/problem/1987
 * @mem
 * @time
 * @caution
 */

public class BJ_G4_1987_알파벳_가지치기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R,C, max,cnt=1, ans=1;
	
	static char[][] board;
	static boolean[] visited;
	static int[][] deltas = { {-1,0}, {1,0},{0,-1},{0,1} };
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		board = new char[R][];
		visited = new boolean[26];//알파벳 26개의 방문 여부
		for (int r = 0; r < R; r++) {
			board[r] = input.readLine().toCharArray();
		}
		//입력 완료
		visited[board[0][0]] = true;
		max = Integer.MIN_VALUE;
		//ㅌ마색
		// BFS - 정점간의 최단거리, 정점간의 거리가 동일하다.
		// DFS - 갈때까지 가보는것 -> 재귀로 구현
		
		//결과출력
		System.out.println(max);
		
		
	}
	// 문제의 다음 정점을 찾는것 - 사방탐색
	private static void dfs(int r, int c, int cnt) {
		// 내가 가고 있는게 최대값?
		max = Math.max(cnt, max);
		// 기저 - 갈 수 있는 방향을 다 가본것
		if(cnt == 26) {
			return;
		}
		// 네 개의 방향으로 탐색하는것 -- 다음 재귀
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc)) {
				char alpha = board[nr][nc];
				if(!visited[alpha]) {
					visited[alpha] = true;
					dfs(nr, nc, cnt);
					visited[alpha] = false; // 안간척...
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return 0<=r && r<R && 0 <=c && c<C;
	}

	static String src = "2 4\r\n" + 
			"CAAB\r\n" + 
			"ADCB";
}
