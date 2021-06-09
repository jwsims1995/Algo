package ps.정올.Beginner.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1402_약수구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		for (int n = 1; n <= N; n++) {
			if(N%n == 0) list.add(n);
		}
		if(list.size() >= K) System.out.println(list.get(K-1));
		else System.out.println(0);
	}
}
