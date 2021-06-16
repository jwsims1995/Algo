package ps.정올.Beginner.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1671_색종이_중 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T ,R, C, ans;
	static int[][] map = new int[101][101];
	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine()); // 1<= T <= 100
	
		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			for (int r = R; r < R+10; r++) {
				for (int c = C; c < C+10; c++) {
					map[r][c] = 1;
				}
			}
		}

		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if(map[r][c]==1) bfs(r,c);
			}
		}
		
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		System.out.println(ans);
	}
	private static void bfs(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr,nc) && map[nr][nc]==0) {
				map[r][c]=2;
				ans++;
				cnt++;
			}
			
		}
		return;
	}
	private static boolean isIn(int nr, int nc) {
		return 0<= nr && nr < 101 && 0 <= nc && nc < 101;
	}

}

/*
 * 
 
4
3 7
5 2
15 7
13 14


*/
