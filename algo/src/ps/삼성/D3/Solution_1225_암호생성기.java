package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 4.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class Solution_1225_암호생성기 {
	static int T;
	static int SIZE = 8;
	static int[] arr;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String line = null;
		Queue<Integer> queue = new LinkedList<Integer>();

		while((line = input.readLine()) != null && !line.isEmpty()) {
			T = Integer.parseInt(line);
			arr = new int[SIZE];
			tokens = new StringTokenizer(input.readLine());
			int cnt = 1;

			for (int i = 0; i < arr.length; i++) {
				queue.add(Integer.parseInt(tokens.nextToken())) ;
			}
			
			while(true) {
				int move = queue.poll()- cnt;				
				if(move <= 0) {
					queue.add(0);
					break;
				}
				else {
					queue.add(move);
					cnt++;
				}
				if(cnt % 5 == 1) cnt = 1;

			}
			
			output.append("#").append(T);
			for (int i = 0; i < SIZE; i++) {
				output.append(" ").append(queue.poll());
			}
			output.append("\n");
			//////
		}
		System.out.println(output);
	}
}
