package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_S2_2210_숫자판점프 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static String[][] map = new String[5][5];
	static int[][] deltas= {{1,0},{-1,0},{0,1},{0,-1}};
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		for (int i = 0; i < 5; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = tokens.nextToken();
			}
		}//입력완료
		
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				dfs(r,c, 0,"");
			}
		}
		//System.out.println(set);
		System.out.println(set.size());

	}
	private static void dfs(int r, int c, int time,String s) {
		if(time == 6) {
			set.add(s);
			return;
		}
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc)) {
				dfs(nr,nc,time+1,s+map[nr][nc]);
				
			}
		}
	}
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<5 && 0<=nc && nc<5;
	}
	static String src = "1 1 1 1 1\r\n" + 
			"1 1 1 1 1\r\n" + 
			"1 1 1 1 1\r\n" + 
			"1 1 1 2 1\r\n" + 
			"1 1 1 1 1";
}
