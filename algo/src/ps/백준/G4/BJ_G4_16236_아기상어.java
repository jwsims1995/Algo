package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 17.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class BJ_G4_16236_아기상어 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, shark;
	static int[][] space;
	static int[][] deltas = { {0,1}, {0,-1}, {1,0}, {-1,0} };
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		space = new int[N][N];
		shark = 2;
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < N; c++) {
				space[r][c] =Integer.parseInt(tokens.nextToken());
			}
		}
//		for (int[] row : space) {
//			System.out.println(Arrays.toString(row));
//		}
		//물고기 있는 위치 찾기
		int max = Integer.MIN_VALUE;
		int fish_r= 0;
		int fish_c =0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(space[r][c] == 9) continue;
				max = Math.max(max, space[r][c]);
			}
		}
		// 물고기가 없으면 끝내
		if(max == 0 ) {
			Runtime.getRuntime().exit(0);
		}
		// 위치 좌표 찾기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(space[r][c]==max) {
					fish_r = r;
					fish_c = c;
				}
			}
		}
		dfs(fish_r, fish_c);
		
	}

	private static void dfs(int r, int c) {
		
	}

	static String src = "4\r\n" + 
			"4 3 2 1\r\n" + 
			"0 0 0 0\r\n" + 
			"0 0 9 0\r\n" + 
			"1 2 3 4";

}
