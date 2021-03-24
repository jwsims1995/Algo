package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 3. 24.
 * @see
 * @mem
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 */
public class BJ_G4_2638_치즈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M;
	static int[][] map;

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Point> airs;
	static boolean[][] visited ;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		// 입력 완료

		System.out.println(bfs());
	}

	static int bfs() {
		airs = new LinkedList<>();
		visited = new boolean[N][M];

		// 출발점 등록 - 외곽은 언제나 공기
		airs.offer(new Point(0, 0));
		visited[0][0] = true;

		int t = 0;
		while (true) {
			// 현재 큐가 가지고 있는 것까지만 돌아야 한다.!!
			int size = airs.size();
			while (size-- > 0) {
				// 한녀석 끄집어 낸다.
				Point head = airs.poll();
				// 작업... --> 공기 전파 --> 치즈 녹이고 --> 녹은 치즈를 새롭게 공기에 추가
				dfs(head.r, head.c);
			}
			// 새롭게 치즈가 녹아서 생성된 공기가 없다면 그만!!
			if (airs.size() == 0) {
				break;
			}

			// 다음 시작으로 이동
			t++;
		}
		return t;
	}
	
	static void dfs(int r, int c) {
		// 1. 방문 체크
		visited[r][c] = true;
		
		// 2. 사용하기
		
		// 3. 자식 탐색 - 사방탐색
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			// 지점이 영역 안에 있고 미방문이면..
			if(isIn(nr, nc) && !visited[nr][nc]) {
				// 지점이 공기 --> 다음 탐색
				if(map[nr][nc]==0) {
					dfs(nr, nc);
				}
				// 0이 아니면 1 즉 치즈였다.... 접촉 회수를 누적 시켜주고 3이 되면 녹는다 --> 다음 BFS 기점
				else {
					if(++map[nr][nc]==3) {
						airs.offer(new Point(nr, nc));
					}
				}
			}
			
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return 0<= r && r<N && 0<=c && c<M;
	}
	
	
	

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}

	private static String src = "8 9\r\n" +
			"0 0 0 0 0 0 0 0 0\r\n" +
			"0 0 0 1 1 0 0 0 0\r\n" +
			"0 0 0 1 1 0 1 1 0\r\n" +
			"0 0 1 1 1 1 1 1 0\r\n" +
			"0 0 1 1 1 1 1 0 0\r\n" +
			"0 0 1 1 0 1 1 0 0\r\n" +
			"0 0 0 0 0 0 0 0 0\r\n" +
			"0 0 0 0 0 0 0 0 0";
}
