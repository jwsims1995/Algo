package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output;
	static StringTokenizer tokens;
	static int T, H, W, N;
	static char [][] map;
	static char [] move;
	static int[][] deltas = {{0,-1}, {-1,0}, {0,1}, {0,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			H = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			map = new char[H][W];
			
			for(int i=0; i<H; i++) {
				String line = input.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			N = Integer.parseInt(input.readLine());
			move= new char[N];
			String line = input.readLine();
			for (int n = 0; n < N; n++) {
				move[n] = line.charAt(n);
			}
			//입력확인
//			for (char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			/////알고리즘 구현
			
			sol();
			
			for (char[] row : map) {
				System.out.println(Arrays.toString(row));
			}
			//////
		}

	}
	
	static void sol() {
		int posX=0;
		int posY=0;
		//먼저 탱크를 찾아
		a:for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if(map[r][c] == '^' || map[r][c] == 'v'|| map[r][c] == '<'|| map[r][c] == '>') {
					System.out.println("탱크 찾앗다!!");
					posX = r;
					posY = c;
					System.out.println("반복?");
					break a;
				}
			}
			
		}
		//System.out.println(posX + " "+ posY);
		for (int n = 0; n < N; n++) {
			action(move[n], posX, posY);
			for (char[] row : map) {
				System.out.println(row);
			}
			System.out.println();
		}
	}
	
	static void action(char key, int r, int c) {
		if(isIn(r-1,c) && key == 'U') {
			if(map[r-1][c] == '.') {
				System.out.println(map[r-1]);
				map[r-1][c] = map[r][c];
				map[r][c] = '.';
				r--;
			}
		}
		else if(isIn(r+1,c) && key == 'D'){
			if(map[r+1][c] == '.') {
				map[r+1][c] = map[r][c];
				map[r][c] = '.';
				r++;
			}
		}
		else if(isIn(r,c-1) && key == 'L'){
			if(map[r][c-1] == '.') {
				map[r][c-1] = map[r][c];
				map[r][c] = '.';
				c--;
			}
		}
		else if(isIn(r,c+1) && key == 'R'){
			if(map[r][c+1] == '.') {
				map[r][c+1] = map[r][c];
				map[r][c] = '.';
				c++;
			}
		}
		else {	//key == 'S'
			if(isIn(r-1,c) && map[r][c] == '^') {
				for (int i = 1; i < H - r; i++) {
					if(map[r-i][c] == '*') {
						map[r-i][c] = '.';
					}
				}
			}
			else if(isIn(r+1,c) && map[r][c] == 'v') {
				for (int i = 1; i < H - r; i++) {
					if(map[r+i][c] == '*') {
						map[r+i][c] = '.';
					}
				}
			}
			else if(isIn(r,c-1) && map[r][c] == '<') {
				for (int i = 1; i < H - c; i++) {
					if(map[r][c-i] == '*') {
						map[r][c-i] = '.';
					}
				}
			}
			else if(isIn(r,c+1) && map[r][c] == '>') {
				for (int i = 1; i < H - c; i++) {
					if(map[r][c+i] == '*') {
						map[r][c+i] = '.';
					}
				}
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return 0<=r && r<H && 0<=c && c<W;
	}
}
