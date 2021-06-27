package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S2_11724_연결요소의개수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		graph = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		int[] test = {};
		test = new int[]{0,1};
        System.out.println(Arrays.toString(test));
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, map.getOrDefault(1, 0)+1);

        for (int m = 0; m < map.size(); m++) {
			map.get(key)
		}
	}


	
	static String src = "6 5\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"5 1\r\n" + 
			"3 4\r\n" + 
			"4 6";//2
}
