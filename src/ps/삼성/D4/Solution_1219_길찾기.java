package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1219_길찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int t, n;
	static boolean[][] map;
	static boolean [] visit;
	public static void main(String[] args) throws IOException {
		map = new boolean[100][100];
		tokens = new StringTokenizer(input.readLine());
		t = Integer.parseInt(tokens.nextToken());
		n = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < n; i++) {
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			map[start][end] = true;
		}
		bfs(0);
		
		
	}

	private static void bfs(int current) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(current);
		while(!q.isEmpty()) {
			visit[current] = true;
			for (int i = 0; i < 2; i++) {
				if(map[current][i]) {
					bfs(current);
				}else {
					
				}
			}
		}
	}
}
