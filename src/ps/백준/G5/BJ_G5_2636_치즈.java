package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_2636_치즈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	
	static int sero, garo, cheeze, time;
	static int[][]  map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		sero = Integer.parseInt(tokens.nextToken());
		garo = Integer.parseInt(tokens.nextToken());
		map = new int[sero][garo];
		for (int r = 0; r < sero; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < garo; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 1) cheeze++;
			}
		}
		while(cheeze != 0) {
			time++;
			
			bfs();
		}
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}

	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		visit = new boolean[sero][garo];
		visit[0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < deltas.length; i++) {
				
			}
		}
	}
	static String src = "13 12\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";
}
