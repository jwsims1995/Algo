package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_20040_사이클게임 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // bufferdReader로 입력받기
	static StringBuilder output = new StringBuilder(); // stringbuilder를 통해 출력시간 줄이기
	static StringTokenizer tokens; // tokensizer 를 통해 token화를 시키기 위한 준비
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int M = Integer.parseInt(tokens.nextToken());
		int N = Integer.parseInt(tokens.nextToken());
		parent = new int[M+1];
		for(int m=1; m<=M;m++) {
			parent[m] = m;
		}
		for(int n=0;n<N;n++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			if(!union(start, end)) {
				System.out.println(n+1);
				System.exit(0);
			}
		}
		System.out.println(0);
	}


	private static boolean union(int start, int end) {
		int startRoot = find(start);
		int endRoot = find(end);
		
		if(startRoot == endRoot) return false;
		parent[startRoot] = endRoot;
		return true;
	}
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

	static String src = "6 5\n" + 
			"0 1\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"0 3\n" + 
			"4 5";
}
