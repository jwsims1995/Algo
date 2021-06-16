package ps.정올.Beginner.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class JO_3699_변장 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, total;
	static Map<String, Integer> map;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine()); // 1<= T <= 100
		for (int t = 0; t < T; t++) {
			total = 1;
			map = new HashMap<>();
			N = Integer.parseInt(input.readLine()); // 0<=N<=30
			for (int n = 0; n < N; n++) {
				tokens = new StringTokenizer(input.readLine());
				String clothes = tokens.nextToken();
				String type = tokens.nextToken();
				map.put(type, map.getOrDefault(type, 0) + 1);
			}

			for (String key : map.keySet()) {
				total *= (map.get(key) + 1);
			}
			System.out.println(--total);

		}
	}

}
