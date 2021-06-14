package ps.정올.Beginner.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2071_파스칼삼각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		switch (M) {
		case 1:
			sol1();
			break;
		case 2:
			sol2();
			break;
		case 3:
			sol3();
			break;

		}
	}

	private static void sol3() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(r == N-1 || r==c) map[r][c] = 1;				
			}
		}
		for (int r = N-1; r >= 0; r--) {
			for (int c = N-1; c >= 0; c--) {
				if(isExist3(r,c)){
					map[r][c] = map[r+1][c+1] + map[r][c+1];
				}				
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 0) break;
				System.out.printf("%d ", map[r][c]);
			}
			System.out.println();
		}
	}

	private static void sol2() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(c == N-1 || r==c) map[r][c] = 1;				
			}
		}
		for (int r = N-1; r >= 0; r--) {
			for (int c = N-1; c >= 0; c--) {
				if(isExist2(r,c)){
					map[r][c] = map[r+1][c+1] + map[r+1][c];
				}				
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 0)System.out.printf(" ");
				else System.out.printf("%d ", map[r][c]);
			}
			System.out.println();
		}
	}

	private static void sol1() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(c == 0 || r==c) map[r][c] = 1;				
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(isExist1(r,c)){
					map[r][c] = map[r-1][c-1] + map[r-1][c];
				}				
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 0) break;
				System.out.printf("%d ",map[r][c]);
			}
			System.out.println();
		}
		
	}

	private static boolean isExist1(int r, int c) {
		return 0<=r-1 && r-1<N && 0<= c-1 && c-1<N && map[r-1][c-1] != 0 && map[r-1][c] !=0 ;
	}
	private static boolean isExist2(int r, int c) {
		return 0<=r+1 && r+1<N && 0<= c+1 && c+1<N && map[r+1][c+1] != 0 && map[r+1][c] !=0 ;
	}
	private static boolean isExist3(int r, int c) {
		return 0<=r+1 && r+1<N && 0<= c+1 && c+1<N && map[r+1][c+1] != 0 && map[r][c+1] !=0 ;
	}
}
