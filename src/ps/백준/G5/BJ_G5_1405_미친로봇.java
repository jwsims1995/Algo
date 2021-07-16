package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1405_미친로봇 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, total, cnt;
	static int[][] deltas = {{0,1},{0,-1},{-1,0},{1,0}}; //동서남북
	static int[] percent = new int[4];
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		for(int i=0; i<4; i++){
			percent[i] = Integer.parseInt(tokens.nextToken());
		}
		permutation(N, new int[N], new boolean[deltas.length]);
		
		//System.out.println(cnt/total);
		
	}


	private static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if(toChoose == 0) {
			System.out.println(Arrays.toString(choosed));
			total++;
			if(find(choosed)) cnt++;
			return;
		}
		for (int d = 0; d < 4; d++) {
			if(!visited[d]) {
				choosed[choosed.length-toChoose] = d;
				visited[d] = true;
				permutation(toChoose-1, choosed, visited);
				visited[d] = false;
			}
		}
	}


	private static boolean find(int[] choosed) {
		map = new boolean[N][N];
		int r = 0;
		int c = 0;
		for (int i = 0; i < choosed.length; i++) {
			int nr = r+ deltas[choosed[i]][0];
			int nc = c+deltas[choosed[i]][1];
			
			if(map[nr][nc]) return false; // 단순하지않아
			
			else map[nr][nc] = true;
		
			r = nr;
			c = nc;
		}
		
		return true;
	}


	private static String src = "2 25 25 25 25";
}
