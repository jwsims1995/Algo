package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_1520_내리막길 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // bufferdReader로 입력받기
	static StringBuilder output = new StringBuilder(); // stringbuilder를 통해 출력시간 줄이기
	static StringTokenizer tokens; // tokensizer 를 통해 token화를 시키기 위한 준비
	static int T, M, N, ans; // 입력
	static int[][] map; // 이차원배열 map 선언
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 사방 탐색을 위한 deltas 설정

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src)); // String src를 이용해서 미리
		// 입력받은 입력값을 input으로 설정
		ans = 0; // 다음 테스트케이스를 위한 ans 초기화
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken()); // 500 이하 세로 크기
		N = Integer.parseInt(tokens.nextToken()); // 500 이하 가로 크기
		map = new int[M][N]; // 10000 이하의 높이 map 생성
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			for (int n = 0; n < N; n++) {
				map[m][n] = Integer.parseInt(tokens.nextToken()); // map 입력받기
			}
		}
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		} // 입력확인

		dfs(0, 0);

		System.out.println(ans); // ans 출력
	}

	static void dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) { // 오른쪽 맨 아래인 map(M-1, N-1) 로 도착하면 ans++하고 return
			ans++;
			return;
		}
		// 사방탐색했을때 내리막길이면 간다.
		for (int d = 0; d < deltas.length; d++) { // 미리 설정해놓은 deltas를 이용해서 사방탐색
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if (isIn(nr, nc) && map[r][c] > map[nr][nc]) { // nr,nc가 범위에 들고, 내리막길이면 dfs 재귀를 통해 거기로 간다.
				dfs(nr, nc);
			}
		}
	}

	static boolean isIn(int nr, int nc) { // isIn함수로 이차원 배열 범위 내에 있는지 확인
		return nr >= 0 && nr < M && nc >= 0 && nc < N;
	}

	static String src = "4 5\r\n" + 
			"50 45 37 32 30\r\n" + 
			"35 50 40 20 25\r\n" + 
			"30 30 25 17 28\r\n" + 
			"27 24 22 15 10";
}
