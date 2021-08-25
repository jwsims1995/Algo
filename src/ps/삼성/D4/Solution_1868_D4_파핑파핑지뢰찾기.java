package ps.삼성.D4;
/**
 * @since 2021. 3. 18.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1868_D4_파핑파핑지뢰찾기 {
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r=r;
			this.c =c;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, ans;
	static char[][] map;
	static int[][] deltas= {{0,1},{0,-1},{1,0},{-1,0},
							{1,1},{1,-1},{-1,1},{-1,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			ans = 0;
			N = Integer.parseInt(input.readLine());
			map = new char[N][N];
			for(int r=0; r<N; r++) {
				map[r] = input.readLine().toCharArray();
			}
			System.out.println();
			for(char[] row: map) {
				System.out.println(Arrays.toString(row));
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if((char)(countMine(r,c) + '0') == '0' && map[r][c] == '.') {
						change(r,c);
						ans++;
					}
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == '.') {
						change(r,c);
						ans++;
					}
				}
			}
			System.out.println();
			for(char[] row: map) {
				System.out.println(Arrays.toString(row));
			}
			output.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(output);
	}

	private static void change(int r, int c) {
		Queue<Point> queue =new LinkedList<>();
		map[r][c] = (char)(countMine(r,c)+'0');
		if(map[r][c] == '0')queue.add(new Point(r,c));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d=0; d<deltas.length; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				if(isIn(nr,nc) && map[nr][nc] == '.') {
					map[nr][nc] = (char)(countMine(nr,nc)+'0');
					if(map[nr][nc] == '0') queue.add(new Point(nr,nc));
				}
			}
		}
	}
	
	private static int countMine(int r, int c) {
		int cnt =0 ;
		for(int d=0; d<deltas.length;d++) {
			int nr= r+deltas[d][0];
			int nc= c+deltas[d][1];
			if(isIn(nr,nc) && map[nr][nc] == '*')cnt++;
		}
		return cnt;
	}

	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N; 
	}

	static String src = "2\n" + 
			"3\n" + 
			"..*\n" + 
			"..*\n" + 
			"**.\n" + 
			"5\n" + 
			"..*..\n" + 
			"..*..\n" + 
			".*..*\n" + 
			".*...\n" + 
			".*...";
}
