package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 3.
 * @author Jaewon
 * @see https://www.acmicpc.net/problem/15649
 * @mem
 * @time
 * @caution
 */

public class BJ_S3_15649_N과M_1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		int [] choosed = new int [M];
		boolean [] visited = new boolean[N];
		permutation(M, choosed, visited);
		////
		System.out.println(output);
	}
	
	static void permutation(int choose, int[] choosed, boolean[] visited) {
		if(choose == 0) {
			for (int val : choosed) {
				output.append(val).append(" ");
			}
			output.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[choosed.length - choose] = i+1;
				permutation(choose-1, choosed, visited);
				visited[i] = false;
			}
		}
	}
}
