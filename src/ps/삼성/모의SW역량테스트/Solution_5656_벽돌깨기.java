package ps.삼성.모의SW역량테스트;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	
	static class Point(int r, int c, int cnt) {
		int r, c, cnt;
		
	}
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N, W, H, total ,min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());
			
			int [][] map = new int[H][W];
			for (int h = 0; h < H; h++) {
				tokens = new StringTokenizer(input.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(tokens.nextToken());
				}
			}// 입력 완료
			
			
			
			
			
			
			min = Integer.MAX_VALUE;
			go(0, map); // 구슬떨어뜨리기
			output.append("#"+t + " " + min + "\n");
		}
		System.out.println(output);
		
	}
	// 중복순열로 구슬 떨어뜨리기
	private static void go(int cnt, int [][] map) { //cnt : 구슬을 떨어뜨린 횟수
		int [][] newMap = new int[H][W];
		 // 매 열마다 구슬 떨어뜨리는 시도
		for (int c = 0; c < W; c++) {
			// 해당열에 구슬을 떨어뜨려 맞는 벽돌 찾기
			int r = 0;
			while ( r<H && map[r][c] == 0) ++r;
			if(r == H) { // 맞는 벽돌 없음( 모두 빈칸 )
				go(cnt+1, map);
			}else {
				// 기존 cnt -1 구슬까지의 상태로 초기화
				copy();
				// 벽돌깨뜨리기
				boom();
				// 벽돌 내리기 (깨지고 난 빈 공간 처리)
				down();
				// 다음 구슬 던지기
				go(cnt + 1, newMap);
			}
		}
	}
	
	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
	private static void boom() {
		Queue<Point> queue = new LinkedList<>();
	}

	static String src= "5\n"
			+ "3 10 10\n"
			+ "0 0 0 0 0 0 0 0 0 0\n"
			+ "1 0 1 0 1 0 0 0 0 0\n"
			+ "1 0 3 0 1 1 0 0 0 1\n"
			+ "1 1 1 0 1 2 0 0 0 9\n"
			+ "1 1 4 0 1 1 0 0 1 1\n"
			+ "1 1 4 1 1 1 2 1 1 1\n"
			+ "1 1 5 1 1 1 1 2 1 1\n"
			+ "1 1 6 1 1 1 1 1 2 1\n"
			+ "1 1 1 1 1 1 1 1 1 5\n"
			+ "1 1 7 1 1 1 1 1 1 1\n"
			+ "2 9 10\n"
			+ "0 0 0 0 0 0 0 0 0\n"
			+ "0 0 0 0 0 0 0 0 0\n"
			+ "0 1 0 0 0 0 0 0 0\n"
			+ "0 1 0 0 0 0 0 0 0\n"
			+ "1 1 0 0 1 0 0 0 0\n"
			+ "1 1 0 1 1 1 0 1 0\n"
			+ "1 1 0 1 1 1 0 1 0\n"
			+ "1 1 1 1 1 1 1 1 0\n"
			+ "1 1 3 1 6 1 1 1 1\n"
			+ "1 1 1 1 1 1 1 1 1\n"
			+ "3 6 7\n"
			+ "1 1 0 0 0 0\n"
			+ "1 1 0 0 1 0\n"
			+ "1 1 0 0 4 0\n"
			+ "4 1 0 0 1 0\n"
			+ "1 5 1 0 1 6\n"
			+ "1 2 8 1 1 6\n"
			+ "1 1 1 9 2 1\n"
			+ "4 4 15\n"
			+ "0 0 0 0 \n"
			+ "0 0 0 0 \n"
			+ "0 0 0 0 \n"
			+ "1 0 0 0 \n"
			+ "1 0 0 0 \n"
			+ "1 0 0 0 \n"
			+ "1 0 0 0 \n"
			+ "1 0 5 0 \n"
			+ "1 1 1 0 \n"
			+ "1 1 1 9 \n"
			+ "1 1 1 1 \n"
			+ "1 6 1 2 \n"
			+ "1 1 1 5 \n"
			+ "1 1 1 1 \n"
			+ "2 1 1 2 \n"
			+ "4 12 15\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9\n"
			+ "9 9 9 9 9 9 9 9 9 9 9 9";
}
 