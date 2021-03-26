package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1219_길찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int t, n;
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		map = new boolean[100][100];
		tokens = new StringTokenizer(input.readLine());
		t = Integer.parseInt(tokens.nextToken());
		n = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < n; i++) {
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			map[start][end] = true;
		}
		
		
	}
}
