package ps.백준.S2;

import java.io.*;
import java.util.*;

public class BJ_S2_15663_N과M9 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M;
	static Set<String> set = new HashSet<>();
	static int[] num;
	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		tokens =new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		num = new int[N];
		tokens =new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(tokens.nextToken());
		}//입력완료
		
		Arrays.sort(num);

		permutation(M, new int[M], new boolean[N]);
		
		System.out.println(output);
	}
	private static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if(toChoose==0) {
			StringBuilder sb = new StringBuilder();
			for (int c = 0; c < choosed.length; c++) {
				sb.append(choosed[c]).append(" ");
			}
			String str = sb.toString();
			if(set.contains(str)) return;
			set.add(str);

			output.append(str).append("\n");
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if(!visited[i]) {
				choosed[choosed.length - toChoose] = num[i];
				visited[i] = true;
				permutation(toChoose-1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	static String src = "8 8\r\n" + 
			"1 2 3 4 5 6 7 8";
}
