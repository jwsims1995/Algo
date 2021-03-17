package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	static int T, N, MINROOM, MAX;
	static int[][] map;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static boolean[][] isVisited;
	static int deltas[][] = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());

			map = new int[N][N];
			isVisited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}//입력완료
			int max=0;
			int minRoom=1000;
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(!isVisited[i][j]) {

						sol(i,j, cnt, max , minRoom);

					}
				}
			}
			System.out.println(MINROOM);
			System.out.println(MAX);

		}
		
	}
	
	static void sol(int r, int c, int cnt, int max, int minRoom) {
		for (int i = 0; i < deltas.length; i++) {// 상, 하, 좌, 우
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1]; 
			
			if(isIn(nr,nc) && map[nr][nc] == map[r][c]+1) {
				cnt++;
				sol(nr,nc, cnt, max, minRoom);
			}
			max = Math.max(max, cnt);
			minRoom = Math.min(minRoom, map[r][c]);
		}
		MINROOM = minRoom;
		MAX = max;
		return;
	}
	static boolean isIn(int a, int b) {
		return 0<=a && a < N && 0<=b && b < N;
	}
}
