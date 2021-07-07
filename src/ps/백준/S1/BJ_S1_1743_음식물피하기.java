package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_1743_음식물피하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, K, cnt, ans;
	static boolean[][] map, visited;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new boolean[R+1][C+1];
		visited = new boolean[R+1][C+1];
		for(int k = 0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			map[r][c] = true;
		}
		
		for (boolean[] string : map) {
			System.out.println(Arrays.toString(string));
		}
		
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if(map[r][c] && !visited[r][c]) {
					cnt = 0;
					dfs(r,c);
					ans = Math.max(ans, cnt);
				}
			}
		}
		System.out.println(ans);

	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc]) dfs(nr,nc);
		}
	}

	private static boolean isIn(int r, int c) {
		return 1<=r && r<= R && 1<=c && c<= C;
	}

	static String src = "3 4 5\n" + 
			"3 2\n" + 
			"2 2\n" + 
			"3 1\n" + 
			"2 3\n" + 
			"1 1";
}
