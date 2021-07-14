package ps.백준.S5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_2891_카약과강풍 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, S, R;
	static int[] team;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		team = new int[N + 1];
		Arrays.fill(team, 1);
		team[0] = 1;
		tokens = new StringTokenizer(input.readLine());
		for (int s = 0; s < S; s++) {
			team[Integer.parseInt(tokens.nextToken())]--;
		}
		tokens = new StringTokenizer(input.readLine());
		for (int r = 0; r < R; r++) {
			team[Integer.parseInt(tokens.nextToken())]++;
		}
		// 입력완료
		System.out.println(Arrays.toString(team));
		int cantGo = 0;

		for (int i = 1; i < N; i++) {

			if (Math.abs(team[i] - team[i + 1]) == 2) {
				team[i] = 1;
				team[i + 1] = 1;
			}

		}

		System.out.println(Arrays.toString(team));

		for (int i = 0; i < team.length; i++) {
			if (team[i] == 0)
				cantGo++;
		}
		System.out.println(cantGo);
	}

	static String src = "5 3 2\n" + "2 3 4\n" + "3 5";
}
