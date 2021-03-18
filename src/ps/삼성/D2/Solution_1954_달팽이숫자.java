package ps.삼성.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 2.
 * @author Jaewon
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV5PobmqAPoDFAUq&probBoxId=AXdgvuDKbeYDFAUO&type=PROBLEM&problemBoxTitle=0202&problemBoxCnt=3
 * @mem
 * @time
 * @caution
 */

public class Solution_1954_달팽이숫자 {
	static int N, T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][] snail;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			snail = new int[N][N];
			int r= 0;
			int c = -1;
			int val = 1;
			int dir=1;
			
			while(N>0) {
				for(int i=0; i<N; i++) {
					c+=dir;
					snail[r][c] = val;
					val++;
				}N--;
				for(int i=0; i<N; i++) {
					r+=dir;
					snail[r][c] = val;
					val++;
					
				}
				dir *= -1;
			}
			System.out.println("#" + t);
			
			for(int i=0; i<snail.length; i++) {
				for(int j=0; j<snail.length; j++) {
					System.out.printf("%d ", snail[i][j]);
				}
				System.out.println();
			}
			
		}
	}
}
