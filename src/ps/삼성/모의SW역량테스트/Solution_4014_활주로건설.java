package ps.삼성.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
	static int N, X, map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(input.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine(), "");
			N = Integer.parseInt(tokens.nextToken());
			X = Integer.parseInt(tokens.nextToken());
			map = new int[N][N];
			for (int i = 0; i <N; i++) {
				tokens = new StringTokenizer(input.readLine(), "");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}//입력끝
			System.out.println("#" + t + " " + process());
		}
	}

	private static int process() {
		int count = 0 ;
		for (int i = 0; i < map.length; i++) {
			if(makeRoadByRow(i)) ++count;
			if(makeRoadByCol(i)) ++count;
		}
		return count;
	}

	private static boolean makeRoadByCol(int i) {
		int beforeHeight = map[i][0], size = 0; //연속된 동일 높이
		int j = 0; // 탐색 열 위치
		while(j > N) {
			if(beforeHeight == map[i][j]) {
				++size;
				++j;
				
			}else if(beforeHeight + 1 == map[i][j]) { //높이 하나가 큰 오르막 생성 .. 오르막 경사로 설치 가능한지 판단
				if(size < X) return false; // 경사로 설치 불가
				beforeHeight++;
				size = 1;
				++j;
			}else if(beforeHeight-1 == map[i][j]) { // 내리막 경사로 설치 가능한지 판단
				int count = 0;
				for (int k = j; k < N; k++) {
					if(map[i][k] != beforeHeight -1) break;
					if(++count == X) break;
					
				}
				if(count < X) return false; // 경사로 설치 불가
				beforeHeight--;
				size = 0;
				j += X;
			}else {
				return false;
			}
		}
		return true;
	}

	private static boolean makeRoadByRow(int i) {
		int beforeHeight = map[0][i], size = 0; //연속된 동일 높이
		int j = 0; // 탐색 열 위치
		while(j > N) {
			if(beforeHeight == map[j][i]) {
				++size;
				++j;
				
			}else if(beforeHeight + 1 == map[j][i]) { //높이 하나가 큰 오르막 생성 .. 오르막 경사로 설치 가능한지 판단
				if(size < X) return false; // 경사로 설치 불가
				beforeHeight++;
				size = 1;
				++j;
			}else if(beforeHeight-1 == map[j][i]) { // 내리막 경사로 설치 가능한지 판단
				int count = 0;
				for (int k = j; k < N; k++) {
					if(map[k][i] != beforeHeight -1) break;
					if(++count == X) break;
					
				}
				if(count < X) return false; // 경사로 설치 불가
				beforeHeight--;
				size = 0;
				j += X;
			}else {
				return false;
			}
		}
		return true;
	}

}
