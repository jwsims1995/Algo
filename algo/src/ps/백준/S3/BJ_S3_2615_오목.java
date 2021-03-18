package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_2615_오목 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int answer, answerRow, answerCol, cnt= 1;
	static int[][] map = new int[20][20];
	static int[][] deltas = { {0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,1} };
	
	public static void main(String[] args) throws IOException {
		for (int r = 1; r < 20; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 1; c < 20; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		for (int r = 1; r < 20; r++) {
			for (int c = 1; c < 20; c++) {
				if(map[r][c] == 1 || map[r][c] == 2) {
					for (int d = 0; d < deltas.length; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						if(map[nr][nc] == map[r][c]) {
							sol(cnt,nr,nc, deltas[d][0], deltas[d][1]);
						}
					}
				}
			}
		}
		
		if(answerRow>0 || answerCol>0) {
			System.out.println(answer);
			System.out.println(answerRow + " " + answerCol);
		}
		else System.out.println(answer);
		
	}
	private static void sol(int cnt, int originRow, int originCol, int dRow, int dCol) {
		if(cnt == 5 && map[originRow][originCol] == map[originRow+dRow][originCol+dCol]) {
			answer = 0;
			return;
		}
		else if(cnt == 5) {
			answer = map[originRow][originCol];
			answerRow = originRow;
			answerCol = originCol;
			return;
		}
		
		if(map[originRow][originCol] == map[originRow+dRow][originCol+dCol]) {
			cnt++;
			sol(cnt, originRow, originCol, originRow+dRow, originCol+dCol);
		}
		
	}
}
