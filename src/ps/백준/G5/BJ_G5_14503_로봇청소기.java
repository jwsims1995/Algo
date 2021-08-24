package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14503_로봇청소기 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, ans;
	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북 동 남 서

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		
		tokens = new StringTokenizer(input.readLine());
		int nowR = Integer.parseInt(tokens.nextToken()) ;
		int nowC = Integer.parseInt(tokens.nextToken()) ;
		int dir = Integer.parseInt(tokens.nextToken()); // 0 : 북 1 : 동 2: 남 3:서

		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		clean(nowR, nowC, dir);

//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}

//		for(int r=0; r<R; r++) {
//			for(int c=0;c<C;c++ ) {
//				if(map[r][c] == -1) ans++;
//			}
//		}
		System.out.println(ans);
	}

	// 북 -> 서 서 -> 남 남 ->동 동->북

	private static void clean(int r, int c, int dir) {
		if (map[r][c] == 0) {
			map[r][c] = -1; // 현재 위치 청소
			ans++;
		}

		boolean cleaned = false;
		int origin = dir;
		for (int d = 0; d < deltas.length; d++) {
			// 2-a
			int nd = (dir + 3 - d) % 4; // 기준에서 차례로 왼쪽방향

			int nr = r + deltas[nd][0]; // 2-a
			int nc = c + deltas[nd][1];
			if (isIn(nr, nc) && map[nr][nc] == 0) { // 청소하지 않은 공간이라면
				clean(nr, nc, nd);
				cleaned = true;
				break;
			}
		}
		
		// 2-b
		if(!cleaned) { //모두 청소 or 벽
			int nd = (origin + 2) % 4;
			int nr = r + deltas[nd][0];
			int nc = c + deltas[nd][1];
			if(isIn(nr,nc) && map[nr][nc] != 1)
				clean(nr,nc,origin);
		}
		// 2-c

	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	/*
	 * 현재 위치를 청소한다.
	 * 
	 * 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다. -왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그
	 * 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다. -왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	 * -네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다. -네 방향 모두
	 * 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
	 * 
	 * 로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
	 */
	static String src = "11 10\n" + 
			"7 4 0\n" + 
			"1 1 1 1 1 1 1 1 1 1\n" + 
			"1 0 0 0 0 0 0 0 0 1\n" + 
			"1 0 0 0 1 1 1 1 0 1\n" + 
			"1 0 0 1 1 0 0 0 0 1\n" + 
			"1 0 1 1 0 0 0 0 0 1\n" + 
			"1 0 0 0 0 0 0 0 0 1\n" + 
			"1 0 0 0 0 0 0 1 0 1\n" + 
			"1 0 0 0 0 0 1 1 0 1\n" + 
			"1 0 0 0 0 0 1 1 0 1\n" + 
			"1 0 0 0 0 0 0 0 0 1\n" + 
			"1 1 1 1 1 1 1 1 1 1";
}
