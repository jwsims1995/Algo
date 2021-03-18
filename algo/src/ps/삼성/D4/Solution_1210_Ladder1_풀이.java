package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//입력으로 온 것은 스테틱으로 하는편

// 생각할점
// 1. 위 -> 아래 : 선택이 많다. 따라서 목적지에서 거꾸로 시작해보자
// 2. 좌/우가 먼저, 그리고 아래서 위로 올라감
// 3. 지나온 길 표시

//풀이
// 1. 맨 마지막에서 2인 지점 찾기
// 2. 지나지않은 지점을 -1로 표시
// 3. 좌, 우, 상 순으로 탐색 가능 확인
// : 갈 수 있다면 이동 --> 좌표 변경 : 범위, 1인 지점, 
// 상 : 첫 행? 그때의 c가 정답
// 도달하면 c출력, 못하면 -1
public class Solution_1210_Ladder1_풀이 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	static int [][] map;
	static int [][] deltas = {{0, 1} ,{0, -1}, {-1, 0}}; //우 좌 상
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(src));
		input = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			//테케 번호는 읽고 버리자.
			input.readLine();
			map = new int [100][100];
			
			int answer = 0;
			for(int r=0; r<100; r++) {
				tokens = new StringTokenizer(input.readLine(), " ");
				for(int c=0; c<100; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					if(r==99 && map[r][c] == 2) {
//						System.out.println("출발점: " + r+", " +c);
						answer = findPath(r, c);
					}
				}
			}
			output.append("#").append(t).append(" ").append(answer).append("\n");
			
			 //입력 끝나면 확인해보자
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			/////////
		}
		System.out.println(output);
	}
	static int findPath(int r, int c) {
		boolean canGo = true;
		// while의 반복 하나가 한칸의 진전을 나타낸다.
		while(canGo) {
			// 배수진을 치자.
			canGo = false;
			// 여기에서 다음으로 가지 못하면.. 반복을 벗어나고 -1 리턴
			// 거쳐온 곳 -1 이 아닌 값으로 변경해서 지나온 길을 표시해주자.
			map[r][c] = 0; // 내가 간 길은 0으로 바꿈
			
			for(int d=0; d<deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				// 새로운 좌표로 갈 수 있을까?
				if(isIn(nr, nc) && map[nr][nc]==1) { // 범위 안에 있는지 먼저 체크해야함, 여기를 통과하면 가는것!
					// 맨 처음 행이면 끝 !!!
					if(nr == 0) {
						return nc;
					}
					//그렇지 않다면 우리는 이동한다
					r = nr;
					c = nc;
					canGo = true;
					//다음 좌표가 결정되면 다음 방향 체크는 불필요
					break;
				}
			}
		}
		return -1;
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < 100 && 0 <= c && c < 100;
	}
}