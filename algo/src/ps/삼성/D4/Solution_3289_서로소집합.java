package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, M, flag, front,back;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			output.append("#"+t+" ");
			tokens = new StringTokenizer(input.readLine());
			N =Integer.parseInt(tokens.nextToken());
			M =Integer.parseInt(tokens.nextToken());
			parents = new int[N+1];
			make();
			for (int  m= 0;  m< M; m++) {
				tokens = new StringTokenizer(input.readLine());
				//합집합 0 a b
				flag = Integer.parseInt(tokens.nextToken());
				front = Integer.parseInt(tokens.nextToken());
				back = Integer.parseInt(tokens.nextToken());
				if(flag == 0)
					union(front,back);
				else
					findSet(front);
					findSet(back);
					
					if(findSet(front) == findSet(back)) output.append(1);
					else output.append(0);
				//같은집합? 1 a b
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	
	private static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	private static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i]  = i;
		}
	}

}
