package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_21608_상어초등학교2 {
	static class Student {
		int r, c;

		public Student(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, setR, setC;
	
	static int[][] info;
	
	
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Student> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		info = new int[N*N][5];
		int[][] map = new int[N][N];
		for(int i=0; i<N*N; i++) {
			tokens = new StringTokenizer(input.readLine());
			info[i][0] = Integer.parseInt(tokens.nextToken()); //학생 번호
			
			info[i][1] = Integer.parseInt(tokens.nextToken()); //좋아하는 학생 번호
			info[i][2] = Integer.parseInt(tokens.nextToken());
			info[i][3] = Integer.parseInt(tokens.nextToken());
			info[i][4] = Integer.parseInt(tokens.nextToken());
		}
		int[][] empty = new int[N][N];
		findEmpty(empty);  // 주변에  빈칸 구하기
		int cnt =0;
		for(int i=0; i<N*N; i++) {
			go(i, map);
		}

		

		 
	}


	private static void go(int i, int[][] map) {
		boolean isExist = false;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				//1. 비어있는 칸중 인접한 칸에 좋아하는ㅇㅐ가 많을때
				if(map[r][c] == 0) {
					//주변에 좋아하는애 몇명?
					for(int d=0; d<deltas.length; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						if(isIn(nr,nc) && map[nr][nc] == info[i][1] || map[nr][nc] == info[i][2] || map[nr][nc] == info[i][3] || map[nr][nc] == info[i][4]) {
							setR = r;
							setC = c;
							isExist = true;
						}
					}
				}
				//2. 1을 만족하는게 여러개면 인접중 비어있는게 많은 곳
				
				//3. r,c작은순서
			}
		}
	}


	private static void findEmpty(int[][] empty) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(r==0&&c==0 || r==N-1&&c==0 || r==N-1&&c==N-1 || r==0&&c==N-1) empty[r][c] = 2;
				else if(r==0||r==N-1||c==0||c==N-1) empty[r][c] = 3;
				else empty[r][c] = 4;
			}
		}
	}


	private static boolean isIn(int r, int c) {
		return 1 <= r && r <= N && 1 <= c && c <= N;
	}

	static String src = "3\r\n" + "4 2 5 1 7\r\n" + "3 1 9 4 5\r\n" + "9 8 1 2 3\r\n" + "8 1 9 3 4\r\n"
			+ "7 2 3 4 8\r\n" + "1 9 2 5 7\r\n" + "6 5 2 3 4\r\n" + "5 1 9 2 8\r\n" + "2 9 3 1 4";
}
