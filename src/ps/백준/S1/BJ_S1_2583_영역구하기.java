package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_2583_영역구하기 {
	static class Point{
		int r,c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output =new StringBuilder();
	static int R, C, K, cnt, num;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map= new int[R][C];
		visited= new boolean[R][C];
		
		for (int k = 0; k < K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int c1 = Integer.parseInt(tokens.nextToken());
			int r1 = Integer.parseInt(tokens.nextToken());
			int c2 = Integer.parseInt(tokens.nextToken());
			int r2 = Integer.parseInt(tokens.nextToken());
			
			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					map[r][c] = -1;
				}
			}
		}
		//입력
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println();
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 0 && !visited[r][c]) {
					cnt++;
					bfs(r,c);
					list.add(num);
					
//					for (int[] row : map) {
//						System.out.println(Arrays.toString(row));
//					}
//					
//					System.out.println();
				}
			}
		}
		Collections.sort(list);
		
		output.append(cnt).append("\n");
		for (int i = 0; i < list.size(); i++) {
			output.append(list.get(i)).append(" ");
		}
		System.out.println(output);
	}
	private static void bfs(int r, int c) {
		num = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r,c));
		visited[r][c] = true;
		map[r][c] = cnt;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < deltas.length; d++) {
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == 0) {
					queue.add(new Point(nr,nc));
					map[nr][nc] = cnt;
					visited[nr][nc] = true;
					num++;
				}
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	static String src = "5 7 3\n" + 
			"0 2 4 4\n" + 
			"1 1 2 5\n" + 
			"4 0 6 2";

	
}

