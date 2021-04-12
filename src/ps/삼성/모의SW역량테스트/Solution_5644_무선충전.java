package ps.삼성.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, M, A;
	static int[][] map = new int[10][10];
	static int[][] deltas = {{0,0},{0,-1},{0,1},{-1,0},{1,0}}; //정지 + 상하좌우
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken());
			A = Integer.parseInt(tokens.nextToken());
			
			int[] userA = new int[M];
			tokens = new StringTokenizer(input.readLine());
			for (int i = 0; i < userA.length; i++) {
				userA[i] = Integer.parseInt(tokens.nextToken()); 
			}//userA 경로 
			int[] userB = new int[M];
			tokens = new StringTokenizer(input.readLine());
			for (int i = 0; i < userB.length; i++) {
				userB[i] = Integer.parseInt(tokens.nextToken()); 
			}//userB 경로
			AP[] ap = new AP[A];
			for (int a = 0; a < A; a++) {
				tokens = new StringTokenizer(input.readLine());
				ap[a]= new AP(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken())); 
			}// ap 정보
			
			
			output.append("#" + t + " " + )
		}
	}
	
	static class AP{
		int x;
		int y;
		int c;
		int p;
		
		public AP(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y; //좌표
			this.c = c; //충전범위
			this.p = p; //처리량
		}
		
	}

	static String src ="5\r\n" + 
			"20 3\r\n" + 
			"2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3\r\n" + 
			"4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3\r\n" + 
			"4 4 1 100\r\n" + 
			"7 10 3 40\r\n" + 
			"6 3 2 70\r\n" + 
			"40 2\r\n" + 
			"0 3 0 3 3 2 2 1 0 4 1 3 3 3 0 3 4 1 1 3 2 2 2 2 2 0 2 3 2 2 3 4 4 3 3 3 2 0 4 4 \r\n" + 
			"0 1 0 3 4 0 4 0 0 1 1 1 0 1 4 4 4 4 4 3 3 3 0 1 0 4 3 2 1 4 4 3 2 3 2 2 0 4 2 1 \r\n" + 
			"5 2 4 140\r\n" + 
			"8 3 3 490\r\n" + 
			"60 4\r\n" + 
			"0 3 3 3 0 1 2 2 2 1 2 2 3 3 4 4 0 3 0 1 1 2 2 3 2 2 3 2 2 0 3 0 1 1 1 4 1 2 3 3 3 3 3 1 1 4 3 2 0 4 4 4 3 4 0 3 3 0 3 4 \r\n" + 
			"1 1 4 1 1 1 1 1 1 4 4 1 2 2 3 2 4 0 0 0 4 3 3 4 3 3 0 1 0 4 3 0 4 3 2 3 2 1 2 2 3 4 0 2 2 1 0 0 1 3 3 1 4 4 3 0 1 1 1 1 \r\n" + 
			"6 9 1 180\r\n" + 
			"9 3 4 260\r\n" + 
			"1 4 1 500\r\n" + 
			"1 3 1 230\r\n" + 
			"80 7\r\n" + 
			"2 2 2 2 2 2 0 2 2 0 4 0 2 3 3 2 3 3 0 3 3 3 4 3 3 2 1 1 1 0 4 4 4 1 0 2 2 2 1 1 4 1 2 3 4 4 3 0 1 1 0 3 4 0 1 2 2 2 1 1 3 4 4 4 4 4 4 3 2 1 4 4 4 4 3 3 3 0 3 3 \r\n" + 
			"4 4 1 1 2 1 2 3 3 3 4 4 4 4 4 1 1 1 1 1 1 1 1 0 3 3 2 0 4 0 1 3 3 3 2 2 1 0 3 2 3 4 1 0 1 2 2 3 2 0 4 0 3 4 1 1 0 0 3 2 0 0 4 3 3 4 0 4 4 4 4 0 3 0 1 1 4 4 3 0 \r\n" + 
			"4 3 1 170\r\n" + 
			"10 1 3 240\r\n" + 
			"10 5 3 360\r\n" + 
			"10 9 3 350\r\n" + 
			"9 6 2 10\r\n" + 
			"5 1 4 350\r\n" + 
			"1 8 2 450\r\n" + 
			"100 8\r\n" + 
			"2 2 3 2 0 2 0 3 3 1 2 2 2 2 3 3 0 4 4 3 2 3 4 3 3 2 3 4 4 4 2 2 2 0 2 2 4 4 4 4 1 1 1 2 2 2 4 3 0 2 3 3 4 0 0 1 1 4 1 1 1 1 2 2 1 1 3 3 3 0 3 2 3 3 0 1 3 3 0 1 1 3 3 4 0 4 1 1 2 2 4 0 4 1 1 2 2 1 1 1 \r\n" + 
			"4 4 4 0 4 1 1 4 1 1 1 1 3 2 1 2 1 1 4 4 1 0 2 3 4 4 4 4 4 0 1 0 2 2 2 0 2 2 2 2 2 2 3 0 0 1 4 3 3 2 0 0 4 4 4 0 2 0 4 1 1 2 2 0 4 4 0 0 2 0 2 3 3 0 2 3 0 3 4 0 4 3 4 4 3 4 1 1 2 2 2 0 0 1 0 4 1 1 1 4 \r\n" + 
			"3 4 2 340\r\n" + 
			"10 1 1 430\r\n" + 
			"3 10 4 10\r\n" + 
			"6 3 4 400\r\n" + 
			"7 4 1 80\r\n" + 
			"4 5 1 420\r\n" + 
			"4 1 2 350\r\n" + 
			"8 4 4 300\r\n" + 
			"";
}
