package ps.정올.Beginner.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1337_달팽이삼각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = {{1,1},{0,-1},{-1,0}};
	static int[][] map;
	static int N, cnt;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = -1;
			}
		}
//		for (int i = 0; i < N; i++) {
//			Arrays.fill(map[i], -1);			
//		}
		
		cnt = 0;
		map[0][0]=cnt;
		dfs(0,0,0);
		
		//출력
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == -1)break;
				System.out.printf("%d ", map[r][c]);
				
			}
			System.out.println();
		}
		
	}
	
	private static void dfs(int r, int c, int d) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(canGo(nr,nc)) {
				++cnt;
				map[nr][nc] = cnt%10;
				dfs(nr,nc,d);
			}else {
				d = (d+1) % 3;
				if(canGo(r+deltas[d][0], c+deltas[d][1])) {
					dfs(r,c,d);					
				}else {
					return;
				}
			}
		}
	

	private static boolean canGo(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<N && map[nr][nc] == -1;
	}
}
