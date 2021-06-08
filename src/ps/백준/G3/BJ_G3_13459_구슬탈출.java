package ps.백준.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_13459_구슬탈출 {
	static class Turn {
		int redX;
		int redY;
		int blueX;
		int blueY;

		public Turn(int redX, int redY, int blueX, int blueY) {
			super();
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
		}

		@Override
		public String toString() {
			return "Turn [redX=" + redX + ", redY=" + redY + ", blueX=" + blueX + ", blueY=" + blueY + "]";
		}

	}
	static class Point{
		int r;
		int c;
		int d;
		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
		
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, redX, redY, blueX, blueY;
	static char[][] arr;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][][][] visited;
	public static void main(String[] args) throws IOException {

		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		arr = new char[R][C];
		for (int r = 0; r < R; r++) {
			arr[r] = input.readLine().toCharArray();
		}

//		for (char[] row : arr) {
//			System.out.println(Arrays.toString(row));
//		}
		// 입력완료

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (arr[r][c] == 'R') {
					redX = r;
					redY = c;
				} else if (arr[r][c] == 'B') {
					blueX = r;
					blueY = c;
				}
			}
		}
//		System.out.println("blue위치" + blue.x + "," + blue.y);
//		System.out.println("red위치" + red.x + "," + red.y);

		// B와 R, O 위치 저장 (1,3) (3,1)

		visited = new boolean[R][C][R][C];
		System.out.println(sol(redX, redY, blueX, blueY));

	}

	private static int sol(int rx, int ry, int bx, int by) {

		Queue<Turn> queue = new LinkedList<>();
		int time = 1;
		queue.add(new Turn(rx,ry,bx,by));
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- >0) {
				Turn q = queue.poll();
				
				// 4방으로 가기
				for (int d = 0; d < deltas.length; d++) {
					Point red = move(q.redX, q.redY, 0, d);
					Point blue = move(q.blueX, q.blueY, 0, d);
					
					if(arr[blue.r][blue.c] == 'O') return 0;
					if(arr[red.r][red.c] == 'O') return 1;
					
					if(blue.r == red.r && blue.c == blue.r) {
						if(blue.d > red.d) {
							red.r-=deltas[d][0];
							red.c-=deltas[d][1];
						}else {
							blue.r = deltas[d][0];
							blue.c = deltas[d][1];
						}
					}
					if(visited[red.r][red.c][blue.r][blue.c]) continue;
					visited[red.r][red.c][blue.r][blue.c] = true;
					
					queue.add(new Turn(red.r, red.c, blue.r, blue.c));
				}
			}
			//10이하로 성공?
			if(++time > 10) return 0;
		}
		return 0;
	}

	private static Point move(int r, int c, int dist, int d) {
		int rr = r, cc = c;
		while(isIn(rr+deltas[d][0], cc+deltas[d][1]) && arr[rr+deltas[d][0]][cc+deltas[d][1]] != '#' && arr[rr][cc] != 'O') {
			rr += deltas[d][0];
			cc += deltas[d][1];
			dist++;
		}
			return new Point(rr,cc,dist);
	}

	private static boolean isIn(int i, int j) {
		return i>=0 && i<R && j>=0 && j<C;
	}

	static String src = "10 10\r\n" + 
			"##########\r\n" + 
			"#R#...##B#\r\n" + 
			"#...#.##.#\r\n" + 
			"#####.##.#\r\n" + 
			"#......#.#\r\n" + 
			"#.######.#\r\n" + 
			"#.#....#.#\r\n" + 
			"#.#.#.#..#\r\n" + 
			"#...#.O#.#\r\n" + 
			"##########";
}
