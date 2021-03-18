package ps.삼성.D4;
/**
 * @since 2021. 3. 18.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1486_D4_장훈이의높은선반 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, B, ans, sum;
	static int[] top;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			top = new int[N];
			tokens = new StringTokenizer(input.readLine());			
			for (int n = 0; n < N; n++) {
				top[n] = Integer.parseInt(tokens.nextToken());
			}
			powerSet(N,new boolean[N]);
			output.append("#"+t +" " + ans + "\n");
		}
		System.out.println(output);
	}
	private static void powerSet(int toChoose, boolean[] visited) {
		sum = 0;
		if(toChoose == 0) {
			print(visited);
			return;
		}
		visited[visited.length - toChoose] = true;
		powerSet(toChoose-1, visited);
		visited[visited.length - toChoose] = false;
		powerSet(toChoose-1, visited);
	}
	private static void print(boolean[] visited) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < visited.length; i++) {
			if(visited[i])list.add(top[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		if(sum >= B)
			ans = Math.min(ans, sum-B);
	}
	static String src = "10\r\n" + 
			"5 16\r\n" + 
			"3 1 3 5 6\r\n" + 
			"2 10\r\n" + 
			"7 7\r\n" + 
			"3 120\r\n" + 
			"83 64 36\r\n" + 
			"4 416\r\n" + 
			"299 239 116 128\r\n" + 
			"5 1535\r\n" + 
			"351 228 300 623 954\r\n" + 
			"10 2780\r\n" + 
			"268 61 201 535 464 168 491 275 578 153\r\n" + 
			"10 1162\r\n" + 
			"73 857 502 826 923 653 168 396 353 874\r\n" + 
			"15 8855\r\n" + 
			"3711 576 9081 3280 1413 6818 5142 2981 1266 484 5757 2451 6961 4862 2086\r\n" + 
			"15 57209\r\n" + 
			"8903 5737 3749 8960 724 6295 1240 4325 8023 3640 2223 639 4161 5330 4260\r\n" + 
			"20 78988\r\n" + 
			"3811 2307 3935 5052 4936 3473 6432 7032 1560 1992 5332 7000 4020 9344 2732 8815 9924 8998 9540 4640\r\n" + 
			"";
}
