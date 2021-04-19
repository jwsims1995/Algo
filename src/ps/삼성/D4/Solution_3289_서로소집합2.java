package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output;
	static int N, M;
	static int[] p;
	static int[] rank;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
            output = new StringBuilder();
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			p = new int[N+1]; // 초기값? 자기자신 ㅑndex or 안쓰는 index(-1)
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			rank = new int[N+1]; //초기값 0
			
			output.append("#" + t + " ");
			for (int m = 0; m <M; m++) {
				tokens = new StringTokenizer(input.readLine());
				int dir = Integer.parseInt(tokens.nextToken());
				int a = Integer.parseInt(tokens.nextToken());
				int b= Integer.parseInt(tokens.nextToken());
				
				if(dir == 0) { // union(a,b)
					union(a,b);
				}
				else { // dir == 1 : find(a) == find(b) ??
					if(find(a) == find(b)) output.append(1);
					else output.append(0);
				}
			}
			System.out.println(output);
		}
	}
	private static int find(int a) {
		if(p[a] != a) p[a] = find(p[a]);
		return p[a];
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) link(pa,pb);
	}
	private static void link(int pa, int pb) {
		if(rank[pa] > rank[pb]) p[pb] = pa;
		else {
			p[pa]= pb;

		}
		
	}
	static String src = "1\n"
			+ "7 8\n"
			+ "0 1 3\n"
			+ "1 1 7\n"
			+ "0 7 6\n"
			+ "1 7 1\n"
			+ "0 3 7\n"
			+ "0 4 2\n"
			+ "0 1 1\n"
			+ "1 1 1\n"
			+ "";
}

