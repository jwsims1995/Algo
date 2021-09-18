package ps.백준.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_1941_소문난칠공주 {
	static class Info{
		int r,c,cnt;
		
		public Info(int r, int c, int cnt) {
			this.r = r;
			this.c =c;
			this.cnt = cnt;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[][] map;
	static int R,C,N,ans;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		R = 5;
		C= 5;
		N = 7;
		map = new char[R][C];
		for(int r=0; r<R; r++) {
			map[r] = input.readLine().toCharArray();
		}
		//입력완료
//		for(char[] c : map) {
//			System.out.println(Arrays.toString(c));
//		}
		for(int r=0; r<R; r++) {
			for(int c=0 ;c<C;c++) {
				if(map[r][c] == 'S') dfs(N,new Info(r,c,1));
				else dfs(N,new Info(r,c,0));
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int toChoose, Info infos) {
		if(toChoose == 0) {
			if(infos.cnt >= 4)ans++;
			return;
		}
		for(int d=0;d<deltas.length;d++) {
			int nr = infos.r+deltas[d][0];
			int nc = infos.c+deltas[d][1];
			if(isIn(nr,nc)) {
				if(map[nr][nc] == 'S') dfs(toChoose-1,new Info(nr,nc,infos.cnt+1));
				else dfs(toChoose-1,new Info(nr,nc,infos.cnt));
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}

	static String src = "YYYYY\n" + 
			"SYSYS\n" + 
			"YYYYY\n" + 
			"YSYYS\n" + 
			"YYYYY";
}
