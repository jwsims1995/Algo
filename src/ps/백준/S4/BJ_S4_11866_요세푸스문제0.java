package ps.백준.S4;
/**
 * @since 2021. 2. 9.
 * @author Jaewon
 * @see https://www.acmicpc.net/problem/11866
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_S4_11866_요세푸스문제0 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		LinkedList<Integer> LinkedList = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) LinkedList.add(i);
		
		//System.out.println(LinkedList);//입력확인
		output.append("<");
		while(LinkedList.size() > 1) {
			for (int i = 0; i < K-1; i++) {
				LinkedList.add(LinkedList.poll());	
			}
			output.append(LinkedList.poll() + ", ");
		}
		output.append(LinkedList.poll() + ">");
		System.out.println(output);
	}
}
