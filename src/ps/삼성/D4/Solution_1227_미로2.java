package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1227_미로2 {
	static char[][] map;
	static boolean[][] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			input.readLine();
			
			map = new char[100][100];
			visited = new boolean[100][100];
			
			int start = 0;
			int end = 0;
			ans = 0;
			
			for(int r = 0; r < 100; r++) {
				String s = input.readLine();
				for(int c = 0; c < 100; c++) {
					map[r][c] = s.charAt(c);
					if(map[r][c] == '2') {
						start = r;
						end = c;
					}
				}
			}
			dfs(start, end);
			
			output.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(output);
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void dfs(int x, int y) {

		if(map[x][y] == '3') {
			ans = 1;
			return;
		}
		
		visited[x][y] = true;
		
		for(int d = 0; d < deltas.length; d++) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			if(nx < 0 || ny < 0 || nx >= 100 || ny >= 100)
				continue;
			
			if(!visited[nx][ny] && map[nx][ny] != '1') {
				dfs(nx,ny);
				
			}
		}
		visited[x][y] = false;
	}
}
