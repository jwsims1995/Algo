package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14567_선수과목_위상정렬 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static boolean[][] subject;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 과목수
		M = Integer.parseInt(tokens.nextToken()); // 선수조건 수
		subject = new boolean[N+1][N+1];
		int[] dp = new int[N+1];
		int[] in = new int[N+1];
		int cnt = 1;
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int pre = Integer.parseInt(tokens.nextToken());
			int now = Integer.parseInt(tokens.nextToken());
			subject[pre][now] = true;
			in[now]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(in[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int size =queue.size();
			while(size-->0) {
				int now =  queue.poll();
				dp[now] = cnt;
				for (int k =now+1; k <= N; k++) {
					if(subject[now][k]) {
						in[k]--;
						if(in[k]==0) queue.offer(k);
					}
				}
			}
			cnt++;
		}
		
		for (int i = 1; i <= N; i++) {
			output.append(dp[i]).append(" ");
		}
		System.out.println(output);
	}

	private static String src = "6 4\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"2 5\n" + 
			"4 5"; //1 2 3
}
