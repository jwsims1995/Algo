package ps.삼성.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author taeheekim
 */
public class Solution_5656_벽돌깨기_바꾼거 {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	private static int N, W, H, min;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(src));

		int TC = Integer.parseInt(in.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map); // 구슬떨어뜨리기
			System.out.println("#" + t + " " + min);
		}
	}

	// 중복순열로 구슬 떨어뜨리기
	// boolean : true-모두 깨뜨린 상황
	private static void go(int cnt, int[][] map) {// cnt : 구슬을 떨어뜨린 횟수,map : cnt-1 구슬까지의 상태맵
		int result = getRemain(map);
		if (result == 0) { // 모두 빈칸(깨뜨릴 벽돌이 음따!!)
			min = 0;
			return;
		}

		if (cnt == N) {
			min = Math.min(min, result);
			return;
		}

		int[][] newMap = new int[H][W];
		// 매열마다 구슬 떨어뜨리는 시도
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if (map[r][c] > 0) {
					copy(map, newMap);
					boom(newMap, r, c);
					down(newMap);
					go(cnt + 1, newMap);
					break;
				}
			}
		}
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					++count;
			}
		}
		return count;
	}


	static void down(int[][] map) {
		List<Integer> list = new ArrayList<>();
		for(int c=0; c<W;c++) {
			for(int r=H-1; r>=0; r--) {
				if(map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			for(int i=0; i<list.size(); i++) {
				map[H-i-1][c] = list.get(i);
			}
			list.clear();
		}
	}

	private static void boom(int[][] map, int r, int c) {

		Queue<Point> queue = new LinkedList<>();
		if (map[r][c] > 1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 제거처리 (방문처리 효과)
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			int cnt = p.cnt;

			for (int d = 0; d < 4; d++) {
				for (int i = 1; i < cnt; i++) {
					int nr = p.r + deltas[d][0] * i;
					int nc = p.c + deltas[d][1] * i;
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
						queue.offer(new Point(nr, nc, map[nr][nc]));
						map[nr][nc] = 0;
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

	static String src = "5\r\n" + "3 10 10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "1 0 1 0 1 0 0 0 0 0\r\n"
			+ "1 0 3 0 1 1 0 0 0 1\r\n" + "1 1 1 0 1 2 0 0 0 9\r\n" + "1 1 4 0 1 1 0 0 1 1\r\n"
			+ "1 1 4 1 1 1 2 1 1 1\r\n" + "1 1 5 1 1 1 1 2 1 1\r\n" + "1 1 6 1 1 1 1 1 2 1\r\n"
			+ "1 1 1 1 1 1 1 1 1 5\r\n" + "1 1 7 1 1 1 1 1 1 1\r\n" + "2 9 10\r\n" + "0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "1 1 0 0 1 0 0 0 0\r\n"
			+ "1 1 0 1 1 1 0 1 0\r\n" + "1 1 0 1 1 1 0 1 0\r\n" + "1 1 1 1 1 1 1 1 0\r\n" + "1 1 3 1 6 1 1 1 1\r\n"
			+ "1 1 1 1 1 1 1 1 1\r\n" + "3 6 7\r\n" + "1 1 0 0 0 0\r\n" + "1 1 0 0 1 0\r\n" + "1 1 0 0 4 0\r\n"
			+ "4 1 0 0 1 0\r\n" + "1 5 1 0 1 6\r\n" + "1 2 8 1 1 6\r\n" + "1 1 1 9 2 1\r\n" + "4 4 15\r\n"
			+ "0 0 0 0 \r\n" + "0 0 0 0 \r\n" + "0 0 0 0 \r\n" + "1 0 0 0 \r\n" + "1 0 0 0 \r\n" + "1 0 0 0 \r\n"
			+ "1 0 0 0 \r\n" + "1 0 5 0 \r\n" + "1 1 1 0 \r\n" + "1 1 1 9 \r\n" + "1 1 1 1 \r\n" + "1 6 1 2 \r\n"
			+ "1 1 1 5 \r\n" + "1 1 1 1 \r\n" + "2 1 1 2 \r\n" + "4 12 15\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9";
}
