package ps.백준.G4;

import java.io.*;
import java.util.*;

public class BJ_G4_1600_말이되고픈원숭이 {
	static class Monkey {
		int row, col, horseMove, depth;

		public Monkey(int row, int col, int horseMove, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.horseMove = horseMove;
			this.depth = depth;
		}

	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // bufferdReader로 입력받기
	static StringBuilder output = new StringBuilder(); // stringbuilder를 통해 출력시간 줄이기
	static StringTokenizer tokens; // tokenizer 를 통해 token화를 시키기 위한 준비
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -2 }, { 1, 2 }, { 1, -2 }, { -1, 2 },
			{ 2, 1 }, { 2, -1 }, { -2, -1 }, { -2, 1 } };
	static int K, C, R, cnt;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src)); // String src를 이용해서 미리
		K = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		// 입력완료
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		cnt = -1;
		
		bfs();
		
		System.out.println(cnt==-1?-1:cnt);

	}

	private static void bfs() {
		Queue<Monkey> queue = new LinkedList<>();
		queue.offer(new Monkey(0, 0, 0, 0));
		boolean[][][] visited = new boolean[R][C][K + 1];
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Monkey front = queue.poll();
			moveLikeMonkey(queue, front, visited);
			if (front.horseMove < K) { // 말 움직임
				moveLikeHorse(queue, front, visited);
			} 
			
			if(front.row == R-1 && front.col == C-1) {
				cnt = front.depth;
				return;
			}
		}
	}

	private static void moveLikeMonkey(Queue<Monkey> queue, Monkey front, boolean[][][] visited) {
		for (int d = 0; d < 4; d++) {
			int nr = front.row + deltas[d][0];
			int nc = front.col + deltas[d][1];
			if (isIn(nr, nc) && !visited[nr][nc][front.horseMove] && map[nr][nc] == 0) {
				queue.offer(new Monkey(nr, nc, front.horseMove, front.depth + 1));
				visited[nr][nc][front.horseMove] = true;
			}
		}
	}

	private static void moveLikeHorse(Queue<Monkey> queue, Monkey front, boolean[][][] visited) {
		for (int d = 4; d < deltas.length; d++) {
			int nr = front.row + deltas[d][0];
			int nc = front.col + deltas[d][1];
			if (isIn(nr, nc) && !visited[nr][nc][front.horseMove+1]  && map[nr][nc] == 0) {
				queue.offer(new Monkey(nr, nc, front.horseMove + 1, front.depth + 1));
				visited[nr][nc][front.horseMove+1] = true;
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static String src = "1\r\n" + "4 4\r\n" + "0 0 1 1\r\n" + "0 0 1 1\r\n" + "0 0 1 1\r\n" + "1 1 1 0";
}
