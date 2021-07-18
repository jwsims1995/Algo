package ps.백준.G5;

import java.io.*;
import java.util.*;
public class BJ_G5_2636_치즈 {
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c= c;
		}
	}
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,cheeseCnt;
	static int[][] map;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 1) cnt++;
			}
		}//입력완료
		
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}//입력확인
		int time = 0;
		while(true) {
			visited =  new boolean[R][C];
			bfs(0,0);
			time++;
			cheeseCnt = 0;
			countCheese();
			if(cheeseCnt == 0) break;
			
			cnt = cheeseCnt;
			
		}
		
		System.out.println(time);
		System.out.println(cnt);
		
	}

	private static void countCheese() {
		for(int r = 0; r<R; r++) {
			for(int c= 0 ; c<C; c++) {
				if(map[r][c] == 1) cheeseCnt++;
			}
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue =new LinkedList<>();
		queue.offer(new Point(r,c));
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int len = deltas.length;
			for (int d = 0; d < len; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				if(isIn(nr,nc) && !visited[nr][nc]) {
					if(map[nr][nc] == 0) {
						queue.offer(new Point(nr,nc));
						visited[nr][nc] = true;
					}else { // 1일때
						map[nr][nc] = 0;
						visited[nr][nc] = true;
					}
				}
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr>= 0 && nr<R && nc>= 0 && nc<C;
	}

	static String src = "4 3\r\n" + 
			"0 0 0\r\n" + 
			"0 1 0\r\n" + 
			"0 1 0\r\n" +
			"0 0 0";
}

