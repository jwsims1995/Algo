package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S3_2606_바이러스 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static int C,N, cnt;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		C = Integer.parseInt(input.readLine());
		N = Integer.parseInt(input.readLine());
		map = new int[C+1][C+1];
		visited = new boolean[map.length+1];
		for (int n = 0; n < N; n++) {
			tokens =new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		System.out.println(bfs(1));
		//System.out.println(dfs(1));
	}
	private static int dfs(int start) {
		if(visited[start] == true)return cnt;
		
		visited[start] = true;
		for (int c = 0; c < map.length; c++) {
			if(!visited[c] && map[start][c] == 1) {
				cnt++;
				dfs(c);
			}
		}
		return cnt;
	}
	private static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int s = queue.poll();
			for (int c = 1; c < map.length; c++) {
				if(map[s][c] == 1 && !visited[c]) {
					queue.add(c);
					visited[c] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
	static String src = "7\r\n" + 
			"6\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"1 5\r\n" + 
			"5 2\r\n" + 
			"5 6\r\n" + 
			"4 7";
}
