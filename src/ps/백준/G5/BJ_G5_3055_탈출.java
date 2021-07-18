package ps.백준.G5;

import java.io.*;
import java.util.*;

public class BJ_G5_3055_탈출 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, cnt;
	static char[][] map;
	static Queue<Point> waterQueue;
	static Queue<Point> gosumQueue;
	static boolean[][] visited;
	static boolean canGo;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		

		waterQueue = new LinkedList<>();
		gosumQueue = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			String line = input.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == '*') {
					waterQueue.add(new Point(r, c));
				} else if (map[r][c] == 'S') {
					gosumQueue.add(new Point(r, c));
				}
			}
		} // 입력완료

//		for(char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		} //입력확인
		
		bfs();
		
		System.out.println(canGo?++cnt:"KAKTUS");

		
	}

	private static void bfs() {
		//물 참
		while(true) {
			int size = waterQueue.size();
			while(size-->0) {
				Point p = waterQueue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					if(isIn(nr,nc)) {
						if(map[nr][nc] == '.') {
							map[nr][nc] = '*';
							waterQueue.add(new Point(nr,nc));
							visited[nr][nc] = true;
						}
					}
				}
			}
			//고슴이동
			size = gosumQueue.size();
            if(size == 0) return;
			while(size-->0) {
				Point p = gosumQueue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					if(isIn(nr,nc) && !visited[nr][nc]) {
						if(map[nr][nc] == '.') {
							map[nr][nc] = 'S';
							gosumQueue.add(new Point(nr,nc));
						}else if(map[nr][nc] == 'D') {
							canGo = true;
							return;
						}
					}
					
				}
			}
			
			cnt++;
//			System.out.println();
//			for(char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		} //입력확인
			
		}
		//고슴도치 이동
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static String src = "3 3\r\n" + 
			"S.*\r\n" + 
			"...\r\n" + 
			".D.";
}
