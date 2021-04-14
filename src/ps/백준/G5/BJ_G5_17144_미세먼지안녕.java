package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_17144_미세먼지안녕 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, T;
	static int C1, C2; // 공기청정기 위치
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				// 공기청정기 위치설정
				if (map[r][c] == -1 && C1 == 0) {
					C1 = r;
					C2 = r + 1;
				}
			}
		} // 입력완료
		for (int t = 0; t < T; t++) {
			// 미세먼지 확산
			diffuse();
			// 공기청정기 동작 --> 위, 아래 따로 동작
			clean(C1, true);
			clean(C2, false);
		}
		// 남아있는 미세먼지 모두 더해주기
		int dustSum = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]>0) {
					dustSum += map[r][c];
				}
			}
		}System.out.println(dustSum);
	}
	
	static void clean(int cr, boolean isUp) {
		// 초기 이동 방향에 대한 delta: 무조건 오른쪽
		int deltaR = 0;
		int deltaC = 1;
		// 탐색할 지점 정보 - 공기청정기 한칸 오른쪽
		int nr = cr;
		int nc = 1; // 공기청정기의 col은 언제나 0이다.
		
		// 미세먼지의 양을 저장할 변수
		int cur = 0, prev = 0; //청정기 지나쳐오면 미세먼지는 0이니까
		
		while(true) {
			//먼지 이동시키기 - swap 형태
			cur = map[nr][nc];
			map[nr][nc] = prev;
			prev = cur;
			
			// 다음 좌표로 이동
			nr+= deltaR;
			nc += deltaC;
			
			// 탐색하려는 지점이 다시 공기청정기로 오면 땡 ~
			if(nr == nc && nc == 0) {
				break;
			}
			
			// 그렇지 않다면 쭉 가보고 경계가 나오면 방향 바꾸기.
			if(nc == C-1 && nr == cr) { // 출발점에서 오른쪽으로 쭉 이동중 ... 끝에 가면 방향 전
				deltaC = 0;
				deltaR = isUp? -1:1;
			}else if (nc == C-1 && (nr == 0 || nr == R-1)) { // 맨 위나 맨 아
				deltaC = -1;
				deltaR = 0;
			}else if(nc == 0 && (nr==0 || nr == R-1)) {
				deltaC = 0;
				deltaR = isUp? 1: -1;
				
			}
		}
	}

	static void diffuse() {
		// 원본 맵에 정보를 저장하기는 너무 힘들다 --> 백업 생성
		int[][] status = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 각 지점에서 전파될 수 있는 곳의 개수는?
				int cnt = 0;
				if (map[r][c] >= 5) { // 5로 나눠줘야 하므로 4까지는 의미 없다.
					for (int d = 0; d < deltas.length; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						if (isIn(nr, nc) && map[nr][nc] != -1) {
							cnt++;
							status[nr][nc] += map[r][c] / 5;
						}
					}

				}
				// 잔량처리
				status[r][c] += map[r][c] - map[r][c] / 5 * cnt;
			}
			// map 바꿔치기
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

	static String src = "7 8 1\n" + "0 0 0 0 0 0 0 9\n" + "0 0 0 0 3 0 0 8\n" + "-1 0 5 0 0 0 22 0\n"
			+ "-1 8 0 0 0 0 0 0\n" + "0 0 0 0 0 10 43 0\n" + "0 0 5 0 15 0 0 0\n" + "0 0 40 0 0 0 20 0";
}
