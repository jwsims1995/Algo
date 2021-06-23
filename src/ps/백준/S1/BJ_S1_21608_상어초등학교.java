package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_21608_상어초등학교 {
	static class Save{
		int r,c;

		public Save(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, num;
	static int[][] map;
	static int[][] info;
	//static boolean[][] visited;
	static int[][] deltas= {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N+1][N+1];
		//visited = new boolean[N+1][N+1];
		info = new int[(N+1)*(N+1)][4];
		
		for (int n = 0; n < N*N; n++) {
			tokens = new StringTokenizer(input.readLine());
			num = Integer.parseInt(tokens.nextToken());
			info[num][0] = Integer.parseInt(tokens.nextToken());
			info[num][1] = Integer.parseInt(tokens.nextToken());
			info[num][2] = Integer.parseInt(tokens.nextToken());
			info[num][3] = Integer.parseInt(tokens.nextToken());
			
			if(n==0) sol2();
			else {
				int max = 0;
				int sr = 0;
				int sc = 0;
				boolean isMany = false;
				for (int r = 1; r < map.length; r++) {
					for (int c = 1; c < map.length; c++) {
						if(map[r][c] == 0) {
							int tmp = sol1(r,c);
							if(max < tmp) {
								max = tmp;
								sr = r;
								sc = c;
							}
						}
					}
				}
				int cnt = 0;
				for (int r = 1; r < map.length; r++) {
					for (int c = 1; c < map.length; c++) {
						if(map[r][c] == 0) {
							int tmp = sol1(r,c);
							if(max == tmp) {
								cnt++;
								if(cnt>1) {
									isMany = true;
									break;
								}
							}
						}
					}
				}
				
				if(isMany) sol2();
				else {
					map[sr][sc] = num;					
				}
			}
			
		
			// 1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 자리
			
			// 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
			
			// 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
			
		}
//		for (int[] row : info) {
//			System.out.println(Arrays.toString(row));
//		}//info 입력확인
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		
	}
	private static int sol1(int r, int c) {
		int cnt = 0;
		
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc) && (map[nr][nc] == info[num][0] || map[nr][nc] == info[num][1] || map[nr][nc] == info[num][2] || map[nr][nc] == info[num][3]) ) {
				cnt++;
			}
		}
		return cnt;
	}
	private static void sol2() {
		int max = 0;
		int sr=0;
		int sc=0;
		for (int r = 1; r < map.length; r++) {
			for (int c = 1; c < map.length; c++) {
				if(map[r][c] == 0) {
					int tmp = searchAdjacent(r,c);
					if(max < tmp) {
						max = tmp;
						sr = r;
						sc = c;
					}
				}
			}
		}
		map[sr][sc] = num;
	}

	private static int searchAdjacent(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc) && map[nr][nc] == 0) {
				cnt++;
			}
		}
		return cnt;
	}
	private static boolean isIn(int r, int c) {
		return 1<=r && r <=N && 1<=c && c <=N ;
	}
	static String src = "3\r\n" + 
			"4 2 5 1 7\r\n" + 
			"3 1 9 4 5\r\n" + 
			"9 8 1 2 3\r\n" + 
			"8 1 9 3 4\r\n" + 
			"7 2 3 4 8\r\n" + 
			"1 9 2 5 7\r\n" + 
			"6 5 2 3 4\r\n" + 
			"5 1 9 2 8\r\n" + 
			"2 9 3 1 4";
}
