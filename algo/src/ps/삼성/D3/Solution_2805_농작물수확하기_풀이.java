package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 2. 3.
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV7GLXqKAWYDFAXB&probBoxId=AXdmB9SaRgQDFAUO&type=PROBLEM&problemBoxTitle=0203&problemBoxCnt=3
 * @mem
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 */
public class Solution_2805_농작물수확하기_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T, N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				// split 파라미터: 정규 표현식
				String[] splited = input.readLine().split("");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(splited[c]);
				}
			}
			/*
			 * for(int [] row: map) { System.out.println(Arrays.toString(row)); }
			 */
			int answer = calc();
			output.append("#").append(t).append(" ").append(answer).append("\n");

		}
		System.out.println(output);
	}

	static int calc() {
		int answer = 0;
		int half = N / 2;
		for (int r = 0; r < N; r++) {
			int start, len;
			if (r < half) {
				start = half - r;
				len = 2 * r + 1;
			} else {
				start = r - half;
				len = 2 * (N - r) - 1;
			}
			for (int c = start; c < start + len; c++) {
				answer += map[r][c];
			}
		}

		return answer;
	}

	private static String src = "1\r\n" +
			"5\r\n" +
			"14054\r\n" +
			"44250\r\n" +
			"02032\r\n" +
			"51204\r\n" +
			"52212";
}
