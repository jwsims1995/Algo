package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S1_2468_안전영역 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] map;
	static int N;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src)); 
		N = Integer.parseInt(input.readLine());
//		for(int r=0;r<N; r++) {
//			tokens = new StringTokenizer(input.readLine());
//			for(int c=0;c<N;c++) {
//				map[r][c] = Integer.parseInt(tokens.nextToken());
//			}
//		}
		 
		Map<String,Integer> map = new HashMap<>();
		map.put("hi", map.getOrDefault("hi", 0)+1);
		map.put("hi", map.getOrDefault("hi", 0)+1);
		String[] str = {"123", "123"};
        Set<String> set = new HashSet<>();
        for(String l : set)
        
		for(String c : map.keySet())
			
		System.out.println(map);
        Stack<String> stack = new Stack<>();
        String.val
		for(int h=0; h<=N; h++) {
			
		}

		
		
	}
	
	static String src = "5\n" + 
			"6 8 2 6 2\n" + 
			"3 2 3 4 6\n" + 
			"6 7 3 3 2\n" + 
			"7 2 5 3 6\n" + 
			"8 9 5 2 7";
}
