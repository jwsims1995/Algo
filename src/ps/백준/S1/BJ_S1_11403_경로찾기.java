package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_11403_경로찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}//입력완료
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == 1) bfs(r,c);
				
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
			System.out.print(map[r][c] + " ");	
			}
			System.out.println();
		}
		
		
	}
	private static void bfs(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(c);
		visited = new boolean[N];
		while(!queue.isEmpty()) {
			int a = queue.poll();
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && map[a][i] == 1) {
					queue.offer(i);
					map[r][i] = 1;
					visited[i] = true;
				}
			}
		}
	}

}
