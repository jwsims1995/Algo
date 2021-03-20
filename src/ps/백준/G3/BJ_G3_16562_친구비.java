package ps.백준.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G3_16562_친구비 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, k, v, w, a, b, total;
	static int[] A;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		k = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		A = new int[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		make();
		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			a = Integer.parseInt(tokens.nextToken());
			b = Integer.parseInt(tokens.nextToken());
			if (a <= b)
				union(a, b);
			else
				union(b, a);
		}
		for (int i = 1; i <= N; i++) {
			if(i == parent[i]) total+=A[i];
		}
		if(total <= k)
			System.out.println(total);
		else System.out.println("Oh no");
	}

	private static boolean union(int front, int back) {
		int aRoot = findSet(front);
		int bRoot = findSet(back);
		if (aRoot == bRoot) {
			return false;
		}
		parent[bRoot] = aRoot;
		return true;
	}

	private static int findSet(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = findSet(parent[a]);
	}

	private static void make() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

	}

	static String src = "5 3 0\r\n" + 
			"10 10 20 20 30\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"5 4";
}
