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
	static int[][] deltas = { { 1, 1 }, { 1, 0 }, { 0, 1 }, { -1, 1 }, { -1, -1 }, { -1, 0 }, { 0, -1 }, { 1, -1 } };
	static char[][] map = new char[7][7];
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
		solution(N, R, C);
	}

	private static void solution(int N, int[] R, int[] C) {
		for(int n=1; n<=6;n++) {
			Arrays.fill(map[n], '.');			
		}
		map[3][3] = 'W';
		map[4][4] = 'W';
		map[3][4] = 'B';
		map[4][3] = 'B';
		
		for(int n = 0 ; n<N ; n++) {
			if(n%2 == 0)
				map[R[n]][C[n]] = 'B';
			else 
				map[R[n]][C[n]] = 'W';
			
			find(R[n], C[n]);
			
		}
		print();
	}

	private static void print() {
		int black = 0;
		int white = 0;
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				if(map[i][j] == 'B') black++;
				else if(map[i][j]=='W') white++;

				output.append(map[i][j]);
			}
			output.append("\n");
		}
		if(black > white) output.append("Black\n");
		else output.append("White\n");
		System.out.println(output);
	}

	private static void find(int r, int c) {
		char target = map[r][c];
		
		for(int d = 0 ; d<deltas.length; d++) {	
			changeColor(r,c, d, map ,target);
		}
	}

	private static void changeColor(int r, int c, int d, char[][] map, char target) {
		int cnt = 1;
		while(true) {
			int nr = r + deltas[d][0] * cnt;
			int nc = c + deltas[d][1] * cnt;
			if(!isIn(nr,nc)) return;
			if(map[nr][nc] == '.') return;
			else if(map[nr][nc] == target) {
				cnt--;
				break;
			}
			cnt++;
		}
		
		while(cnt>0) {
			int nr = r + deltas[d][0] * cnt;
			int nc = c + deltas[d][1] * cnt;
			map[nr][nc] = target;
			cnt--;
		}
	}

	private static boolean isIn(int r, int c) {
		return 1<=r && r<=6 && 1<=c && c<=6;
	}

	static String src = "6\r\n" + "3 2\r\n" + "4 2\r\n" + "5 3\r\n" + "2 2\r\n" + "2 1\r\n" + "3 5";
}
