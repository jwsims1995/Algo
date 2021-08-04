package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 3.
 * @author Jaewon
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV5LyE7KD2ADFAXc&probBoxId=AXdmB9SaRgQDFAUO&type=PROBLEM&problemBoxTitle=0203&problemBoxCnt=1
 * @mem
 * @time
 * @caution
 */


public class Solution_1873_상호의배틀필드 {
	static class Point{
		int r,c;
		char d;
		public Point(int r, int c, char d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, H, W, N;
	static int nowR, nowC;
	static char [][] map;
	static char [] move;
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static Point tank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			H = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			map = new char[H][W];
			for (int r = 0; r < H; r++) {
				String line = input.readLine();
				map[r] = line.toCharArray();
			}//입력완료
//			for(char[] c : map) {
//				System.out.println(Arrays.toString(c));
//			}//입력확인완료
			
			N = Integer.parseInt(input.readLine());
			move = input.readLine().toCharArray();
			start(findTank());
			
			output.append("#").append(t).append(" ");
			
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					output.append(map[r][c]);
				}
				output.append("\n");
			}
		}
		System.out.println(output);
	}
	
	private static void start(Point tank) {
		int moveCnt = move.length;
		int dir = 0;
		int r = tank.r;
		int c = tank.c;
		for(int m=0; m<moveCnt; m++) {
			
			char key = move[m];
			
			
			if(key == 'S') {
				if(map[r][c]=='^') {
					dir = 0;
				}else if(map[r][c] == 'v') {
					dir = 1;
				}else if(map[r][c] == '<') {
					dir = 2;
				}else if(map[r][c] == '>') {
					dir = 3;
				}
				shot(dir,r,c);
				
			}else if(key == 'U') {
				map[r][c] = '^';
				if(!isIn(r-1,c))continue;
				if(map[r-1][c] == '.') {
					map[r-1][c] = '^';
					map[r][c] = '.';
					r= r-1;
//					tank = new Point(r-1,c,'^');
				}
			}else if(key == 'R') {
				map[r][c] = '>';
				if(!isIn(r,c+1))continue;
				if(map[r][c+1] == '.') {
					map[r][c+1] = '>';
					map[r][c] = '.';
					c = c+1;
//					tank = new Point(r,c+1,'>');
				}
			}else if(key == 'L') {
				map[r][c] = '<';
				if(!isIn(r,c-1))continue;
				if(map[r][c-1] == '.') {
					map[r][c-1] = '<';
					map[r][c] = '.';
					c = c-1;
//					tank = new Point(r,c-1,'<');
				}
			}else if(key == 'D') {
				map[r][c] = 'v';
				if(!isIn(r+1,c))continue;
				if(map[r+1][c] == '.') {
					map[r+1][c] = 'v';
					map[r][c] = '.';
					r= r+1;
//					tank = new Point(r+1,c,'v');
				}
			}
		}
	}

	private static void shot(int dir, int r, int c) {
		
		int i = 1;
		while(true) {			
			
			int nr = r + deltas[dir][0] * i;
			int nc = c + deltas[dir][1] * i;
			
			if(!isIn(nr,nc)) return;
			
			if(map[nr][nc] == '#') return;
			
			if(map[nr][nc]=='*') {
				map[nr][nc] = '.';
				return;
			}
			i+=1;
		}
	}

	private static Point findTank() {
		tank = null;
		for(int r = 0; r<H; r++) {
			for(int c=0; c<W;c++) {
				if(map[r][c] == '^' ||map[r][c] == 'v' ||map[r][c] == '<' ||map[r][c] == '>') {
					tank = new Point(r,c, map[r][c]);
					return tank;
				}
			}
		}
		return tank;
	}

	static boolean isIn(int r, int c) {
		return 0<=r && r<H && 0<=c && c<W;
	}
	
	static String src = "1\n" + 
			"4 6\n" + 
			"*.*..*\n" + 
			"*.....\n" + 
			"..-...\n" + 
			"^.*#..\n" + 
			"0\n" + 
			"\n";
}
