package ps.백준.S4;

import java.io.*;
import java.util.*;

public class BJ_S4_1978_소수찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[] map = new boolean[1001];
		map[1] = true;
		map[0] = true;
		for (int i = 2; i <= 1000; i++) {
			if(map[i]) continue; 
			for (int j = 2*i; j <= 1000; j+=i) {
				map[j] = true;
			}
		}
		
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		tokens =new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(!map[num]) cnt++;
		}
		System.out.println(cnt);
	}
	static String src ="4\n" + 
			"1 3 5 7";

}
