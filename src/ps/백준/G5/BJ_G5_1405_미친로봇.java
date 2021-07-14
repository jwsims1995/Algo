package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_1405_미친로봇 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] deltas = {{0,1},{0,-1},{-1,0},{1,0}}; //동서남북
	static int[] percent = new int[4];
	static int[][] map;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		for(int i=0; i<4; i++){
			percent[i] = Integer.parseInt(tokens.nextToken());
		}
		map = new int[N][N];
		
		
	}


	private static String src = "2 25 25 25 25";
}
