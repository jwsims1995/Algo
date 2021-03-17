package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 2. 5.
 * @see
 * @mem
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 */
public class Solution_1861_정사각형방_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int N;
	static int[][] rooms;
	// index를 방 번호로 각각 방에서 이동하는 회수
	static int[] moved;

	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			rooms = new int[N][N];
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine(), " ");
				for (int c = 0; c < N; c++) {
					rooms[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			/*
			 * for(int [] row: rooms) { System.out.println(Arrays.toString(row)); } // 완료
			 */
			// 초기화는 반대로~~
			int max = Integer.MIN_VALUE;
			// 크기 주의!! 방은 1부터, 인덱스는 0부터.
			moved = new int[N * N + 1];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 각각의 점에서 이동 최대 거리를 찾아보자...
					// 그 값으로 moved 도 업데이트 해주자.
					//moved[rooms[r][c]] = travel(r, c);
					moved[rooms[r][c]] = travelRecur(r, c);
					// 이동한 회수가 최대?
					max = Math.max(max, moved[rooms[r][c]]);
				}
			}

			// 모든 점에서의 방문이 종료!! 그럼 답을 찾아 볼까나~~~
			for (int i = 0; i < moved.length; i++) {
				// 배열이 가진 값과 max가 같은 점이 최대 이동한 방 번호!!!!
				if (moved[i] == max) {
					output.append(String.format("#%d %d %d%n", t, i, moved[i]));
					// output.append("#").append(t).append(" ").append(i).append("
					// ").append(moved[i]).append("\n");
					// output.append("#"+t+" " + i + " " + moved[i] + "\n");
					break;
				}
			}
		}
		System.out.println(output);
	}

	static int travelRecur(int r, int c) {
		if (moved[rooms[r][c]] > 0) {
			return moved[rooms[r][c]];
		}

		for (int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			// 영역 안에 있고 이동 대상 방이 현재의 방보다 1 크다면...
			if (isIn(nr, nc) && rooms[nr][nc] == rooms[r][c] + 1) {
				return 1 + travelRecur(nr, nc);
			}
		}
		return 1;
	}

	private static int travel(int r, int c) {
		// 출발부터 1칸
		int moveCnt = 1;

		boolean canGo = true;

		outer: while (canGo) {
			// 배수의 진의 치자!!! 사방탐색에 실패한다면 우리는 그만 둘꺼야..
			canGo = false;
			for (int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				// 영역 안에 있고 이동 대상 방이 현재의 방보다 1 크다면...
				if (isIn(nr, nc) && rooms[nr][nc] == rooms[r][c] + 1) {
					// 새로운 방에서 기존의 이동 흔적을 찾아보자.
					if (moved[rooms[nr][nc]] > 0) {
						moveCnt += moved[rooms[nr][nc]];
						// 외부에 있는 반복문을 벗어나야 한다.
						break outer;
					}
					// 처음 와본 방이야~~~
					else {
						r = nr;
						c = nc;
						moveCnt++;
						canGo = true;
						break;// 이동 가능한 점은 사방에서 딸랑 하나~
					}
				}
			}
		}
		return moveCnt;
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	private static String src = "2\r\n" +
			"2\r\n" +
			"1 2\r\n" +
			"3 4\r\n" +
			"3\r\n" +
			"9 3 4\r\n" +
			"6 1 5\r\n" +
			"7 8 2";
}
