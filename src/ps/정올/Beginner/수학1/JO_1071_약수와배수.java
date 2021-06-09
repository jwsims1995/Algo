package ps.정올.Beginner.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1071_약수와배수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M; // 100<= ㅇ <1000
	static int sumYak, sumBae;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(tokens.nextToken());
			list.add(tmp);
		}
		M = Integer.parseInt(input.readLine());

		for (int i = 0; i < N; i++) {
			if (M % list.get(i) == 0) {
				sumYak += list.get(i);

			}
		}

		for (int i = 0; i < N; i++) {
			if (list.get(i) % M == 0)
				sumBae += list.get(i);
		}

		System.out.println(sumYak);
		System.out.println(sumBae);
	}
}
