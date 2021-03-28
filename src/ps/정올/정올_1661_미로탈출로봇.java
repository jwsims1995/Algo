package ps.정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정올_1661_미로탈출로봇 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int X, Y;
	static char[][] map;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static Point start, end;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		X = Integer.parseInt(tokens.nextToken()); // 8
		Y = Integer.parseInt(tokens.nextToken()); // 7
		tokens = new StringTokenizer(input.readLine());
		int startX = Integer.parseInt(tokens.nextToken());
		int startY = Integer.parseInt(tokens.nextToken());
		int endX = Integer.parseInt(tokens.nextToken());
		int endY = Integer.parseInt(tokens.nextToken());
		start = new Point(startX, startY);
		end = new Point(endX, endY);
		map = new char[Y+1][X+1];
		
		for (int y = 1; y <= Y; y++) {
			String line = input.readLine();
			for (int x = 1; x <= X; x++) {
				map[y][x] = line.charAt(x-1);
			}
		}
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}

		bfs(start);
	}

	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		boolean[][] visit = new boolean[Y+1][X+1];
		visit[start.y][start.x] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point q = queue.poll();
				if(q.x == end.x && q.y == end.y) {
					System.out.println(cnt);
					return;
				}
				for (int d = 0; d < deltas.length; d++) {
					int nx = q.x + deltas[d][0];
					int ny = q.y + deltas[d][1];
					if(isIn(nx,ny) && !visit[ny][nx] && map[ny][nx] == '0') {
						queue.offer(new Point(nx,ny));
						visit[ny][nx] = true;
					}
				}		
			}
			cnt++;
		}
	}

	private static boolean isIn(int nx, int ny) {
		return 1<=nx && nx <= X && 1<=ny && ny <= Y;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	static String src = "8 7\r\n" + "1 2 7 5\r\n" + "11111111\r\n" + "00000111\r\n" + "10110011\r\n" + "10111001\r\n"
			+ "10111101\r\n" + "10000001\r\n" + "11111111";

}
