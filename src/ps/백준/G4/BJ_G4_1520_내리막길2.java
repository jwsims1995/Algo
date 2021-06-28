package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_1520_내리막길2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // bufferdReader로 입력받기
	static StringBuilder output = new StringBuilder(); // stringbuilder를 통해 출력시간 줄이기
	static StringTokenizer tokens; // tokensizer 를 통해 token화를 시키기 위한 준비
	static int T, M, N, ans; // 입력
	static int[][] map; // 이차원배열 map 선언
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 사방 탐색을 위한 deltas 설정

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src)); // String src를 이용해서 미리
		// 입력받은 입력값을 input으로 설정
		
	}
	static boolean isIn(int nr, int nc) { // isIn함수로 이차원 배열 범위 내에 있는지 확인
		return nr >= 0 && nr < M && nc >= 0 && nc < N;
	}

	static String src = "4 5\r\n" + 
			"50 45 37 32 30\r\n" + 
			"35 50 40 20 25\r\n" + 
			"30 30 25 17 28\r\n" + 
			"27 24 22 15 10";
}
