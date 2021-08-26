package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_1717_집합의표현 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder(); 
	static StringTokenizer tokens; 
	static int N, M;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		parent = new int[N + 1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int check = Integer.parseInt(tokens.nextToken());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			if(check == 1) { // 두개 포함되어있냐
				if(find(a) == find(b)) output.append("YES").append("\n");
				else output.append("NO").append("\n");
			}
			else { // 합쳐
				union(a,b);
			}
			
		}
		System.out.println(output);

	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		parent[b] = a;
		return true;
	}

	private static int find(int a) {
		if(a == parent[a]) return a;
		
		return parent[a] = find(parent[a]);
	}

	static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < M && nc >= 0 && nc < N;
	}

	static String src = "7 8\n" + 
			"0 1 3\n" + 
			"1 1 7\n" + 
			"0 7 6\n" + 
			"1 7 1\n" + 
			"0 3 7\n" + 
			"0 4 2\n" + 
			"0 1 1\n" + 
			"1 1 1";
}
