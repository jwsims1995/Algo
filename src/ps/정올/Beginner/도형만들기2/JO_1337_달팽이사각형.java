package ps.정올.Beginner.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1337_달팽이사각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] map;
	static int N, cnt;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];

		sol(0,0,0);
		
		//출력
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				output.append(map[i][j]).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output);
		
	}

	private static void sol(int r, int c, int d) {
		map[r][c] = ++cnt;
		while(true) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(!canGo(nr,nc)) {
				d = (d+1)%4;
				if(map[r][c] == 1) {
					break;
				}
			}else {
				map[nr][nc] = ++cnt;				
				if(map[nr][nc] == N*N)break;
				r = nr;
				c = nc;
			}
		}
	}

	private static boolean canGo(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N && map[r][c]==0;
	}
	
}
