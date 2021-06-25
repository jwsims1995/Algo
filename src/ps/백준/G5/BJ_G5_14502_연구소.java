package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14502_연구소 {
	static class Virus{
		int r,c;

		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, ans; // 3<= R,C <= 8
	static int[][] map;
	static int[][] copy_map;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		// 입력완료
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}//입력확인

		dfs(0);
		
		System.out.println(ans);
	}

	

	private static void dfs(int wall) {
		if(wall == 3) { // 벽이 3개 쌓이면 바이러스 뿌려
			
			ans = Math.max(ans, spread());
			
			return;
		}
		// 벽세우기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					dfs(wall+1);
					map[r][c] = 0;
				}
			}
		}
	}



	private static int spread() {
		Queue<Virus> queue = new LinkedList<>();
		
		copyMap();
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(copy_map[r][c] == 2) {
					queue.offer(new Virus(r,c));
					while(!queue.isEmpty()) {
						Virus v = queue.poll();
						for (int d = 0; d < deltas.length; d++) {
							int nr = v.r + deltas[d][0];
							int nc = v.c + deltas[d][1];
							if(isIn(nr,nc) && copy_map[nr][nc] == 0) {
								queue.offer(new Virus(nr,nc));
								copy_map[nr][nc] = 2;
							}
						}
					}
					
				}
			}
		}
		return safeZone(0);
		
	}



	private static int safeZone(int cnt) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(copy_map[r][c] == 0) cnt++;
			}
		}
		return cnt;
	}



	private static void copyMap() {
		copy_map = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copy_map[r][c] = map[r][c];
			}
		}
	}



	private static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static String src = "8 8\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0";
}
