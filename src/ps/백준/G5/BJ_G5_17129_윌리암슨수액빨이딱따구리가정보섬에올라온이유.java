package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_17129_윌리암슨수액빨이딱따구리가정보섬에올라온이유 {
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N, M, cnt, ans;
	static int[][] map;
	static int R, C;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map  = new int[N][M];
		for (int r = 0; r < N; r++) {
			String[] str = input.readLine().split("");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(str[c]);
				if(map[r][c] == 2) {
					R=r;
					C = c;
				}
			} 
		}//입력완료
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}//입력확인
		bfs();
		
		if(ans > 0) {
			output.append("TAK").append("\n").append(cnt);
		}
		else output.append("NIE");
		;
		
		System.out.println(output);
	}


	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(R,C));
		boolean[][] visited = new boolean[N][M];
		visited[R][C] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Point p = queue.poll();
				if(map[p.r][p.c] > 2) {//음식발견
					ans = map[p.r][p.c];
					return;
				}
				int deltaSize = deltas.length;
				for (int d = 0; d < deltaSize; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					if(isIn(nr,nc) && map[nr][nc] != 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new Point(nr,nc));
					}
				}
			}
			cnt++;
		}
		
	}


	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M ;
	}


	private static String src = "3 3\n" + 
			"200\n" + 
			"003\n" + 
			"045"; //5
}
