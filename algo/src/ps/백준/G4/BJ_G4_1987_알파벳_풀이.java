package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 2. 19.
 * @see
 * @mem
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 */
public class BJ_G4_1987_알파벳_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int R, C;
	static char[][] map;
	static boolean[] visited;
	static int max;

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		map = new char[R][];
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
		}
		// 입력 완료
		// 알파벳의 방문 여부를 확인할 배열
		visited = new boolean['Z' + 1];
		// 0,0이 언제나 출발점
		visited[map[0][0]] = true;
		max = Integer.MIN_VALUE;
		// 탐색
		// BFS - 정점간의 최단거리, 정점간의 거리가 동일하다.
		// DFS - 갈때까지 가보는것 -> 재귀로 구현
		dfs(0, 0, 1);
		// 결과 출력
		System.out.println(max);

	}

	// 문제의 다음 정점을 찾는것 - 사방탐색
	static void dfs(int r, int c, int cnt) {
		// 내가 가고 있는게 최대값???
		max = Math.max(cnt, max);
		// 기저 - 갈 수 있는 방향을 다 가본것
		
		// 가지치기
		if (cnt == 26) {
			return;
		}

		// 네개의 방향으로 탐색하는것 -- 다음 재귀
		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if (isIn(nr, nc)) {
				char alpha = map[nr][nc];
				if (!visited[alpha]) {
					visited[alpha] = true;
					dfs(nr, nc, cnt + 1);
					visited[alpha] = false;// 안간척...
				}
			}
		}

	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	private static String src = "2 4\r\n" +
			"CAAB\r\n" +
			"ADCB";
}
