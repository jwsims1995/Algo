package ps.백준.S4;

import java.io.*;
import java.util.*;

public class BJ_S4_2164_카드2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i<=N; i++) {
			queue.offer(i);
		}
		while(true) {
			if(queue.size() == 1) break;
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
	}
	static String src ="6";

}
