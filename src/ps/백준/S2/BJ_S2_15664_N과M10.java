package ps.백준.S2;

import java.io.*;
import java.util.*;

public class BJ_S2_15664_N과M10 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M;
	static Set<String> set = new LinkedHashSet<>();
	static int[] num;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		num = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(tokens.nextToken());
		} // 입력완료

		Arrays.sort(num);

		combination(M, new int[M], 0);

		for (String str : set) {
			output.append(str).append("\n");
		}

		System.out.println(output);
	}

	private static void combination(int toChoose, int[] choosed, int idx) {
		if (toChoose == 0) {
			StringBuilder sb = new StringBuilder();
			for (int c = 0; c < choosed.length; c++) {
				sb.append(choosed[c]).append(" ");
			}
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < num.length; i++) {
			choosed[choosed.length - toChoose] = num[i];
			combination(toChoose - 1, choosed, i);
		}
	}

	static String src = "4 2\r\n" + 
			"9 7 9 1";
}
