package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 2. 19.
 * @see
 * @mem
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 */
public class BJ_S1_1992_쿼드트리_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new char[N][];
		for (int r = 0; r < N; r++) {
			map[r] = input.readLine().toCharArray();
		}
		// 입력 완료/
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//			
//		}
		// 탐색
		dnc(0, 0, N);
		// 결과 출력
		System.out.println(output);

	}

	/**
	 * 
	 * @param r 탐색 출발 r,
	 * @param c 탐색 출발 c
	 * @param n 길이.
	 */
	static void dnc(int r, int c, int n) {
		// 기저조건 - 찾는 영역의 색이 모두 같으면 종료
		// 영역의 값이 같으면 압축할 필요가 없다.
		if (isSame(r, c, n)) {
			output.append(map[r][c]);
			return;
		}
		// 재귀 - 4개로 쪼개서 들어간다. -- ()로 감싸줘야한다.!!
		output.append("(");
		// 4개의 자식 영역의 값을 찾아봐.
		int m = n / 2;
		dnc(r, c, m);
		dnc(r, c + m, m);
		dnc(r + m, c, m);
		dnc(r + m, c + m, m);
		output.append(")");
	}

	static boolean isSame(int r, int c, int l) {
		for (int r2 = r; r2 < r + l; r2++) {
			for (int c2 = c; c2 < c + l; c2++) {
				if (map[r2][c2] != map[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

	static String src = "8\r\n" +
			"11110000\r\n" +
			"11110000\r\n" +
			"00011100\r\n" +
			"00011100\r\n" +
			"11110000\r\n" +
			"11110000\r\n" +
			"11110011\r\n" +
			"11110011\r\n" +
			"";
}
