package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_1600_말이되고픈원숭이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int K, W, H;
	static int[][] map;
	// 원숭이 이동
	static int[][] deltaM = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	// 말이동
	static int[][] deltaH = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

	static Queue<Monkey> queue;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		K = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine(), " ");
		W = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		map = new int[H][W];

		for (int r = 0; r < H; r++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력 완료.

		System.out.println(bfs());
	}

	static int bfs() {
		queue = new LinkedList<>();
		visited = new boolean[H][W][K + 1];
		// 초기 상태
		queue.offer(new Monkey(0, 0, 0));
		visited[0][0][0] = true;

		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				// 사용하기......
				Monkey head = queue.poll();

				// 목적지?
				if (head.row == H - 1 && head.col == W - 1) {
					return depth;
				}

				// 자식 탐색
				// 1. 원숭이로 이동
				moveLike(deltaM, head, true);
				// 2. 말로 이동 - 말로 이동할 수 있는 회수가 남아있다면.. 말로 이동..
				if(head.horseMove < K) {
					moveLike(deltaH	, head, false);
				}
			}
			// 턴이 하나 종료
			depth++;
		}
		return -1;
	}

	static void moveLike(int[][] deltas, Monkey m, boolean isMonkey) {
		// 자식 탐색
		for (int d = 0; d < deltas.length; d++) {
			int nr = m.row + deltas[d][0];
			int nc = m.col + deltas[d][1];

			if (isIn(nr, nc) && map[nr][nc] == 0) {
				// 말로 이동인지,, 원숭이로 이동인지.. --> 원숭이의 말이동 회수가 달라진다..
				int horseMove = isMonkey ? m.horseMove : m.horseMove + 1;
				if (!visited[nr][nc][horseMove]) {
					Monkey newMonkey = new Monkey(nr, nc, horseMove);
					queue.add(newMonkey);
					visited[nr][nc][horseMove] = true;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < H && 0 <= c && c < W;
	}

	static class Monkey {
		int row, col, horseMove;

		public Monkey(int row, int col, int horseMove) {
			super();
			this.row = row;
			this.col = col;
			this.horseMove = horseMove;
		}

		@Override
		public String toString() {
			return "Monkey [row=" + row + ", col=" + col + ", horseMove=" + horseMove + "]";
		}

	}

	private static String src = "1\r\n" +
			"4 4\r\n" +
			"0 0 0 0\r\n" +
			"1 0 0 0\r\n" +
			"0 0 1 0\r\n" +
			"0 1 0 0";
}
