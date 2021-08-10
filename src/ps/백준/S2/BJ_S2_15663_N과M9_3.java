package ps.백준.S2;

import java.io.*;
import java.util.*;

public class BJ_S2_15663_N과M9_3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int[] arr;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(arr);

		// permutation(M, new int[M], new boolean[N]);
		np(M, new int[M], 0);

		System.out.println(output);

	}

	private static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if (toChoose == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i : choosed) {
				sb.append(i).append(" ");
			}
			String str = sb.toString();
			if (set.contains(str))
				return;
			set.add(str);

			output.append(str).append("\n");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				choosed[choosed.length - toChoose] = arr[i];
				visited[i] = true;
				permutation(toChoose - 1, choosed, visited);
				visited[i] = false;
			}
		}
	}

	private static void np(int toChoose, int[] choosed, int flag) {
		if (toChoose == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i : choosed) {
				sb.append(i).append(" ");
			}
			String str = sb.toString();
			if (set.contains(str))
				return;
			set.add(str);

			output.append(str).append("\n");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if ((flag & (1 << i)) > 0)
				continue;

			choosed[choosed.length - toChoose] = arr[i];
			np(toChoose - 1, choosed, flag | (1 << i));

		}
	}

	static String src = "4 2\r\n" + "9 7 9 1";
}
