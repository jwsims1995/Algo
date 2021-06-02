import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇이동거리 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N, cnt;
	static char[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우 순
	static boolean[][] visited;

	/*
	 * A : 우 B : 좌우 C : 상하좌우
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			cnt = 0;
			map = new char[N][N];
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = tokens.nextToken().charAt(0);
				}
			}
			for (char[] c : map) {
				System.out.println(Arrays.toString(c));
			} // 입력완료
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'A' || map[r][c] == 'B' || map[r][c] == 'C') {
						//sol(r, c);
						bfs(r,c);
					}
				}
			}
			output.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(output);
	}


	private static void sol(int r, int c) {
		switch (map[r][c]) {
		case 'C':// 상하좌우
			for (int d = 0; d < 4; d++) {
				dfs(r, c, d);
			}
			break;
		case 'B':// 좌우
			for (int d = 2; d < 4; d++) {
				dfs(r, c, d);
			}
			break;
		case 'A':// 우
			dfs(r, c, 3);
			break;
		}
	}

	private static void dfs(int r, int c, int d) {
		int nr = r + deltas[d][0];
		int nc = c + deltas[d][1];
		if (isIn(nr, nc) && !visited[nr][nc]) {
			if (map[nr][nc] == 'S') {
				visited[nr][nc] = true;
				cnt++;
				dfs(nr, nc, d);
				visited[nr][nc] = false;
			}
		}
	}
	
	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

	static String src = "3\r\n" + "6\r\n" + "S A S S W S\r\n" + "S W A S C S\r\n" + "S W S W S S\r\n"
			+ "S W S S W S\r\n" + "S B S S W S\r\n" + "S S S S S S\r\n" + "3\r\n" + "S S A\r\n" + "B W W\r\n"
			+ "S W C\r\n" + "10\r\n" + "C S S S S S S S S C\r\n" + "S W S S S S S S W S\r\n" + "S S W S S S S W S S\r\n"
			+ "A S S W S S W S S A\r\n" + "S S S S S B S S S S\r\n" + "S S S S B S S S S S\r\n"
			+ "A S S W S S W S S A\r\n" + "S S W S S S S W S S\r\n" + "S W S S S S S S W S\r\n" + "C S S S S S S S S C";
}
