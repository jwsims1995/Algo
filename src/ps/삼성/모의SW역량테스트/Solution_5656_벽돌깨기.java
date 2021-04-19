package ps.삼성.모의SW역량테스트;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N, W, H, total, min;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());

			int[][] map = new int[H][W];
			for (int h = 0; h < H; h++) {
				tokens = new StringTokenizer(input.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(tokens.nextToken());
				}
			} // 입력 완료
			min = Integer.MAX_VALUE;
			go(0, map); // 구슬떨어뜨리기
			output.append("#" + t + " " + min + "\n");
		}
		System.out.println(output);
	}
	// 중복순열로 구슬 떨어뜨리기
	private static void go(int cnt, int[][] map) { // cnt : 구슬을 떨어뜨린 횟수
		
		if(cnt == N) {
			int result = getRemain(map);
			if(result == 0) { // 모두 
				
			}
		}
		
		int[][] newMap = new int[H][W];
		// 매 열마다 구슬 떨어뜨리는 시도
		for (int c = 0; c < W; c++) {
			// 해당열에 구슬을 떨어뜨려 맞는 벽돌 찾기
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;
			if (r == H) { // 맞는 벽돌 없음( 모두 빈칸 )
				go(cnt + 1, map);
			} else {
				// 기존 cnt -1 구슬까지의 상태로 초기화
				copy(map, newMap);
				// 벽돌깨뜨리기
				boom(newMap, r, c);
				// 벽돌 내리기 (깨지고 난 빈 공간 처리)
				down(newMap);
				// 다음 구슬 던지기
				go(cnt + 1, newMap);
			}
		}
	}
	
	private static int getRemain(int[][] map) {
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] > 0) ++count;
			}
		}
		return count;
	}
	
	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			int r = H-1;
			while(r >= 0 && map[r][c] == 0) --r;
			if(r < 0) continue; // 모두 빈칸이면 내릴것이 없으므로 옆 열 내리기
			
			r = H-1;
			while(r>0) { // 자신의 위치에 내리
				if(map[r][c] == 0) { // 빈칸이면
					//직전부터 위족 탐색하며 가장 가까운 벽돌찾기
					int nr = r-1;
					while(nr > 0 && map[nr][c] == 0) --nr;
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				--r;
			}
			
	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		if (map[r][c] > 1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 제거 처리 ( 방문처리 효과 )

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if (map[r][c] > 1) {
							queue.offer(new Point(r, c, map[nr][nc]));
						}
						map[nr][nc] = 0; //visit 관리처럼
					}
				}
			}
		}
	}

	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	static String src = "5\n" + "3 10 10\n" + "0 0 0 0 0 0 0 0 0 0\n" + "1 0 1 0 1 0 0 0 0 0\n"
			+ "1 0 3 0 1 1 0 0 0 1\n" + "1 1 1 0 1 2 0 0 0 9\n" + "1 1 4 0 1 1 0 0 1 1\n" + "1 1 4 1 1 1 2 1 1 1\n"
			+ "1 1 5 1 1 1 1 2 1 1\n" + "1 1 6 1 1 1 1 1 2 1\n" + "1 1 1 1 1 1 1 1 1 5\n" + "1 1 7 1 1 1 1 1 1 1\n"
			+ "2 9 10\n" + "0 0 0 0 0 0 0 0 0\n" + "0 0 0 0 0 0 0 0 0\n" + "0 1 0 0 0 0 0 0 0\n" + "0 1 0 0 0 0 0 0 0\n"
			+ "1 1 0 0 1 0 0 0 0\n" + "1 1 0 1 1 1 0 1 0\n" + "1 1 0 1 1 1 0 1 0\n" + "1 1 1 1 1 1 1 1 0\n"
			+ "1 1 3 1 6 1 1 1 1\n" + "1 1 1 1 1 1 1 1 1\n" + "3 6 7\n" + "1 1 0 0 0 0\n" + "1 1 0 0 1 0\n"
			+ "1 1 0 0 4 0\n" + "4 1 0 0 1 0\n" + "1 5 1 0 1 6\n" + "1 2 8 1 1 6\n" + "1 1 1 9 2 1\n" + "4 4 15\n"
			+ "0 0 0 0 \n" + "0 0 0 0 \n" + "0 0 0 0 \n" + "1 0 0 0 \n" + "1 0 0 0 \n" + "1 0 0 0 \n" + "1 0 0 0 \n"
			+ "1 0 5 0 \n" + "1 1 1 0 \n" + "1 1 1 9 \n" + "1 1 1 1 \n" + "1 6 1 2 \n" + "1 1 1 5 \n" + "1 1 1 1 \n"
			+ "2 1 1 2 \n" + "4 12 15\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n" + "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9";
}
