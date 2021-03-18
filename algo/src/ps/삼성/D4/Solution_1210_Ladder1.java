package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 2.
 * @author Jaewon
 * @see https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
 * @mem
 * @time
 * @caution
 * &단순배열, $시뮬레이션,
 * [고려사항]
 * [입력사항]
 * 총 테케는 10개로 고정
 * [출력사항]
 */


public class Solution_1210_Ladder1 {
	
	static int TestCase = 10;
	static int ROW = 100, COL = 100;
	static int[][] data = new int[ROW][COL];
	static boolean[][] step = new boolean[ROW][COL];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int tcNum;
	static int[][] deltas = {{1,0},{-1,0},{1,0}};//하 좌 우
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int t = 1; t <= TestCase; t++) {
			tcNum = Integer.parseInt(br.readLine());
			for(int i=0; i<ROW; i++) {
				tokens = new StringTokenizer(br.readLine());
				for(int j=0; j<COL; j++) {
					data[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
//			for (int[] row : data) {
//				System.out.println(Arrays.toString(row));
//			}
			
			bye : for(int r=0; r<ROW; r++) {
				if(data[r][0] == 1){
					int c= 0;
					
					for(int i=0;i<ROW;i++) {
						for(int j=0;j<COL;j++) {
							step[i][j]=false;
						}
					}//step 초기화
					
					answer = r;
					while(isIn(r,c)) {
						if(data[r+1][c]==1 && step[r+1][c] == false){ //오른쪽 확인
							step[r++][c] = true;
						}
						else if(data[r-1][c] ==1 && step[r-1][c] == false) { // 왼쪽 확인
							step[r--][c] = true;
						}
						else if(data[r][c+1] ==1 && step[r][c+1] == false) { // 아래 확인
							step[r][c++] = true;
						}

						if(data[r+1][c] == 2 ||data[r-1][c] == 2 ||data[r][c+1] == 2) {
							break bye;
						}
					}
				}
			}
			System.out.println(answer);
			
			/////////
		}
	}
	
	
	public static boolean isIn(int r, int c) {
		return 1 <= r && r < 99 && 1 <= c && c < 99;
	}
}