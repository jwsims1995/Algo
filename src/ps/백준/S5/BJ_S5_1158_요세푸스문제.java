package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S5_1158_요세푸스문제 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, num;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			queue.add(n);
		}
		output.append("<");
		while(queue.size()>1) {	
			for (int i = 0; i < K-1; i++) {
				queue.add(queue.poll());
			}
			output.append(queue.poll()).append(", ");
		}
		output.append(queue.poll()).append(">");
		System.out.println(output);
	}

}
