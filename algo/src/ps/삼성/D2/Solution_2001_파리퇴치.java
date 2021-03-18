package ps.삼성.D2;
/**
 * @since 2021. 2. 3.
 * @author Jaewon
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV5PzOCKAigDFAUq&probBoxId=AXdmB9SaRgQDFAUO&type=PROBLEM&problemBoxTitle=0203&problemBoxCnt=3
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M ,T;
	static int [][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		
		for (int t = 1; t <= T; t++) {
			int answer = 0;

			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			//입력확인
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}

			
			
			for(int r=0; r<N-M+1; r++) {
				for (int c = 0; c < N-M+1; c++) {
					answer = Math.max(answer, cal(r,c));
				}
			}
			
			
			
			/////
			output.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(output);
	}
	
	static int cal(int r, int c) {
		int sum = 0;
		for (int i = r; i < M+r; i++) {
			for (int j = c; j < M+c; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
}
