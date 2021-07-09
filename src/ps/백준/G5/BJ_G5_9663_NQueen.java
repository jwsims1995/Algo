package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_9663_NQueen {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt;
	static int[] map;
	static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N];
		
		nQueen(0);
	}


	private static void nQueen(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			map[depth] = i;
			if(isPossible(depth)) {
				nQueen(depth+1);
			}
		}
	}


	private static boolean isPossible(int depth) {
		return ;
	}


	private static String src = "8";
}
