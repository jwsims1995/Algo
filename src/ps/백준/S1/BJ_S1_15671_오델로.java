package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_15671_오델로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = {{0, 1},{0, -1},{1 ,0},{-1, 0},{1,1 },{1, -1},{-1, 1},{-1,-1}};

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int[] R = new int[N];
		int[] C = new int[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			R[n] = Integer.parseInt(tokens.nextToken());
			C[n] = Integer.parseInt(tokens.nextToken());
		}
		solution(N, R,C);
	}
	
	private static void solution(int N, int[] R, int[] C) {
		char[][] map = new char[7][7]; // r,c는 1부터
		init(map, N);
		
		for (char[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		// N번 계속 바꿔줘
		for (int n = 0; n < N; n++) { // 검정부터니까 n%2==0 이면 B
			if(n%2 == 0) { 
				map[R[n]][C[n]] = 'B';
			}else {
				map[R[n]][C[n]] = 'W';
			}
			changeColor(map, R[n], C[n]);
			
			
			
		}
		System.out.println();
		//출력
		for(char[] row : map) {
			System.out.println(Arrays.toString(row));			
		}
	}

	private static void changeColor(char[][] map, int r, int c) {
		char target = map[r][c];
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			int find = 0;
			
			if(isIn(nr,nc) && map[nr][nc] != target) go(nr, nc, d, target, map);
		}
	}

	private static void go(int r, int c, int d, char target, char[][] map) {
		while(true) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc) && map[nr][nc] == target) break;
			map[nr][nc] = target;
		}
	}


	private static boolean isIn(int r, int c) {
		return 1<=r && r<=6 && 1<=c && c<=6;
	}

	private static void init(char[][] map, int N) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if((r==3 && c == 3) || (r==4 && c == 4)) map[r][c] = 'W';
				else if((r==3 && c == 4) || (r==4 && c == 3)) map[r][c] = 'B';
				else map[r][c] = '.';
			}
		}
	}

	static String src = "6\r\n" + 
			"3 2\r\n" + 
			"4 2\r\n" + 
			"5 3\r\n" + 
			"2 2\r\n" + 
			"2 1\r\n" + 
			"3 5";
}
