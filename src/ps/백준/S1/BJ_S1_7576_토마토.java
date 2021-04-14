package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_7576_토마토 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C;
	static Queue<Point> queue;
	static int totalTomatoCnt;
	static int[][] box;
	static boolean [][] visited;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken()); 
		box = new int[R][C];
		visited = new boolean[R][C];
		queue = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				box[r][c] = Integer.parseInt(tokens.nextToken());
				// 익은 토마토 : BFS 탐색의 기점
				if(box[r][c] == 1) {
					queue.offer(new Point(r,c));
					visited[r][c] = true;
				}
				// 아직 안익은 토마토 :익혀야할(탐색해야할 노드)
				else if(box[r][c] == 0) {
					totalTomatoCnt++;
				}
			}
		}// 입력완료
		
		System.out.println(bfs());
	}

	static int bfs() {
		//1. 초기화
		//근데 이미 input과정에 q생성, 넣고, visited 다 했어
		int day = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s= 0; s < size ; s++){  //그 개수까지만 소모
				// 2. 맨 앞의 녀석 가져오기
				Point p = queue.poll();
				// 3. 사용한다.
				// 4. 다음 노드 탐색
				for (int d = 0; d < deltas.length; d++) {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					
					if(!isIn(nr,nc) || visited[nr][nc] || box[nr][nc] != 0) continue;
					visited[nr][nc] = true;
					queue.offer(new Point(nr,nc));
					totalTomatoCnt--;
				}
			}// 오늘의 작업 끝~~
			if(queue.size() > 0) day++; // 토마토가 남아있다면 내일 작업하러 가보자
		}
		//모든 작업 종료
		return totalTomatoCnt ==0? day : -1;
	}

	private static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C ;
	}

	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static String src = "6 4\n"
			+ "0 0 0 0 0 0\n"
			+ "0 0 0 0 0 0\n"
			+ "0 0 0 0 0 0\n"
			+ "0 0 0 0 0 1";
}
