package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_16956_늑대와양 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C;
	static int canGo = 1;
	static char[][] map;
	static int[][] deltas=  {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
		}
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		for (int r = 0; r < R && canGo == 1; r++) {
			for (int c = 0; c < C && canGo==1; c++) {
				if(map[r][c] == 'S') defense(r,c);
			}
		}
		if(canGo==1) {
			output.append(canGo).append("\n");
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					output.append(map[r][c]);
				}
				output.append("\n");
			}
			System.out.println(output);
		}
		else {
			System.out.println(canGo);
		}
		
	}

	private static void defense(int r, int c) {
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc)) {
				if(map[nr][nc] == '.')
					map[nr][nc] = 'D';
				else if(map[nr][nc] =='W')
					canGo = 0;
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return 0<=r && r<R && 0<=c && c<C;
	}
	
	static String src = "6 6\r\n" + 
			"..S...\r\n" + 
			"..S.W.\r\n" + 
			".S....\r\n" + 
			"..W...\r\n" + 
			"...W..\r\n" + 
			"......";
}
