package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 9.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class Solution_1233_사칙연산유효성검사 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, result;
	static String[] btree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(input.readLine());
			btree = new String[N+1];
			result = 1;
			for (int n = 1; n <= N; n++) {
				btree = input.readLine().split(" ");
				int x = Integer.parseInt(btree[0]);
				char c = btree[1].charAt(0);
				if(N < x*2 + 1) { // 리프노드
					if(!('0'<c && c<='9')) result = 0;
				}
				else {
					if('0'<c && c<='9') result = 0;
				}
				
			}
			output.append("#" + t +" " + result + "\n");
		}
		System.out.println(output);
	}
}
