package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2468_안전영역 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int top, ans;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src)); 
		N = Integer.parseInt(input.readLine());
		map= new int[N][N];
		for(int r=0;r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				top =  Math.max(top, map[r][c]);
			}
		}
		for(int h=0; h<=top;h++) { // 차오르는 높이
			//map 복제
			visited = new boolean[N][N];
			//visited처리
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] <= h) {
						visited[r][c] = true;
					}
				}
			}
			ans = Math.max(ans, findMax(h));
		}
		System.out.println(ans);
		
	}
	
	private static int findMax(int h) {
		int cnt =0 ;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					dfs(r,c);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc) && !visited[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

	static String src = "7\n" + 
			"9 9 9 9 9 9 9\n" + 
			"9 2 1 2 1 2 9\n" + 
			"9 1 8 7 8 1 9\n" + 
			"9 2 7 9 7 2 9\n" + 
			"9 1 8 7 8 1 9\n" + 
			"9 2 1 2 1 2 9\n" + 
			"9 9 9 9 9 9 9";
}
