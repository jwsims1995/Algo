package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3499_퍼펙트셔플 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N;
	static String[] card;
	static String[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			card = input.readLine().split(" ");
			answer = new String[N];
			int cnt = 0;
			for (int i = 0; i < N; i += 2) {
				answer[i] = card[cnt++];
			}
			for (int i = 1; i < N; i += 2) {
				answer[i] = card[cnt++];
			}

			output.append("#" + t);
			for (String each : answer) {
				output.append(" " + each);
			}
			output.append("\n");
			////
		}
		System.out.println(output);

	}

}
