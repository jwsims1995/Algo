package ps.정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 정올_1863_종교 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, front, back, cnt;
	static int[] parents;
	HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		parents = new int[N+1];
		make();
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			front = Integer.parseInt(tokens.nextToken());
			back = Integer.parseInt(tokens.nextToken());
			
			union(front, back);
		}
		//System.out.println(Arrays.toString(parents));
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			//set.add(parents[i]);
			//set.add(findSet(i));
			if(i == parents[i]) cnt++;
		}
		
		//System.out.println(set);
		//System.out.println(set.size());
		System.out.println(cnt);

	}
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	private static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}
	
	private static void make() {
		for (int n = 1; n <= N; n++) {
			parents[n] = n;
		}
	}
	static String src = "10 9\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"1 5\r\n" + 
			"1 6\r\n" + 
			"1 7\r\n" + 
			"1 8\r\n" + 
			"1 9\r\n" + 
			"1 10";
}
