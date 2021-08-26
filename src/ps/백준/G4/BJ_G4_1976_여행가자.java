package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_1976_여행가자 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder(); 
	static StringTokenizer tokens; 
	static int N, M;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=1; j<=N; j++) {
				if(Integer.parseInt(tokens.nextToken()) == 1) {
					union(i,j);
				}
			}
		}
		
		tokens = new StringTokenizer(input.readLine());
		int target = find(Integer.parseInt(tokens.nextToken()));
		
		for(int i=1;i<M;i++) {
			if(target != find(Integer.parseInt(tokens.nextToken()))) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
		
	}

	private static boolean union(int i, int j) {
		int iRoot = find(i);
		int jRoot = find(j);
		
		if(iRoot == jRoot) return false;
		parent[iRoot] = jRoot;
		return true;
		
	}

	private static int find(int i) {
		if(i==parent[i]) return i;
		return parent[i] = find(parent[i]);
	}

	static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < M && nc >= 0 && nc < N;
	}

	static String src = "3\n" + 
			"3\n" + 
			"0 1 0\n" + 
			"1 0 1\n" + 
			"0 1 0\n" + 
			"1 2 3";
}
