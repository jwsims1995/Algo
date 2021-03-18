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

public class BJ_G4_1987_알파벳 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C, cnt=1, ans=1;
	static char[][] board;
	static boolean[] visited;
	static int[][] deltas = { {-1,0}, {1,0},{0,-1},{0,1} };
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		board = new char[R][C];
		visited = new boolean[26];//알파벳 26개의 방문 여부
		for (int r = 0; r < R; r++) {
			String row = input.readLine();
			for (int c = 0; c < C; c++) {
				board[r][c] = row.charAt(c);
			}
		}
//		for (char[] row : board) {
//			System.out.println(Arrays.toString(row));
//		}
		
		dfs(board, visited, 0,0);
		System.out.println(ans);
		
		
		
	}
	
	private static void dfs(char[][] board, boolean[] visited, int row, int col) {
		int idx = board[row][col] - 'A';
		visited[idx] = true;
		for (int d = 0; d < deltas.length; d++) {
			int nr = row + deltas[d][0];
			int nc = col + deltas[d][1];
			
			if(isIn(nr,nc)) {
				int next = board[nr][nc] - 'A';
				
				if(!visited[next]) {
					ans = Math.max(++cnt, ans);
					dfs(board, visited, nr, nc);
				}
			}
			
		}
		--cnt;
		visited[idx] = false;
	}

	private static boolean isIn(int r, int c) {
		return 0<=r && r<R && 0 <=c && c<C;
	}

	static String src = "2 4\r\n" + 
			"CAAB\r\n" + 
			"ADCB";
}
