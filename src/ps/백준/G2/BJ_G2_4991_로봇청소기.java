package ps.백준.G2;

import java.io.*;
import java.util.*;

public class BJ_G2_4991_로봇청소기 {
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R,C, robotR, robotC, dust, cnt;
	static char[][] map;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		while(true) {
			cnt = 0;
			dust = 0;
			tokens = new StringTokenizer(input.readLine());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken()); 
			if(C==0 && R==0) {
				System.out.println(output);
				return;
			};
			map = new char[R][C];
			int idx = 1;
			Point[] info = new Point[11];
			for(int r =0; r<R; r++) {
				String line = input.readLine();
				for(int c=0 ;c<C; c++) {
					map[r][c] = line.charAt(c);
					if(map[r][c] == 'o') info[0] = new Point(r,c);
					else if (map[r][c] =='*') info[cnt++] = new Point(r,c);
				}
			}//입력완료
			List<Point> list = new ArrayList<>();
		}
	}



	private static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C ;
	}

	static String src = "7 5\r\n" + 
			".......\r\n" + 
			".o...*.\r\n" + 
			".......\r\n" + 
			".*...*.\r\n" + 
			".......\r\n" + 
			"15 13\r\n" + 
			".......x.......\r\n" + 
			"...o...x....*..\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			"...............\r\n" + 
			"xxxxx.....xxxxx\r\n" + 
			"...............\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			".......x.......\r\n" + 
			"..*....x....*..\r\n" + 
			".......x.......\r\n" + 
			"10 10\r\n" + 
			"..........\r\n" + 
			"..o.......\r\n" + 
			"..........\r\n" + 
			"..........\r\n" + 
			"..........\r\n" + 
			".....xxxxx\r\n" + 
			".....x....\r\n" + 
			".....x.*..\r\n" + 
			".....x....\r\n" + 
			".....x....\r\n" + 
			"0 0";
}
