package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_1197_최소스패닝트리 {
	static class Node implements Comparable<Node>{
		int start, end, cost;
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // bufferdReader로 입력받기
	static StringBuilder output = new StringBuilder(); // stringbuilder를 통해 출력시간 줄이기
	static StringTokenizer tokens; // tokensizer 를 통해 token화를 시키기 위한 준비
	static int V, E; // 입력
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src)); // String src를 이용해서 미리
		// 입력받은 입력값을 input으로 설정
		tokens = new StringTokenizer(input.readLine());
		V = Integer.parseInt(tokens.nextToken()); // 500 이하 세로 크기
		E = Integer.parseInt(tokens.nextToken()); // 500 이하 가로 크기
		parent = new int[V+1];
		for(int i=1; i<=V;i++) {
			parent[i] = i;
		}
		int ans= 0;
		Node[] node = new Node[E];
		for(int e=0; e<E; e++) {
			tokens = new StringTokenizer(input.readLine());
			int a= Integer.parseInt(tokens.nextToken());
			int b= Integer.parseInt(tokens.nextToken());
			int c= Integer.parseInt(tokens.nextToken());
			node[e] = new Node(a,b,c);
		}
		Arrays.sort(node);
		int cnt =0;
		boolean isMST = false;
		for(int e=0; e<E; e++) {
			int start = node[e].start;
			int end = node[e].end;
			if(union(start, end)) {
				ans += node[e].cost;
				cnt++;
			}
			if(cnt == V-1) {
				isMST = true;
				break;
			}
		}
		System.out.println(ans);
//		System.out.println(isMST?ans:-1);
		
	}
	static boolean union(int start, int end) {
		int startRoot = find(start);
		int endRoot = find(end);
		
		if(startRoot == endRoot) return false;
		
		if(startRoot > endRoot) parent[startRoot] = endRoot;
		else parent[endRoot] = startRoot;
		return true;
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

	
	static String src = "3 3\n" + 
			"1 2 1\n" + 
			"2 3 2\n" + 
			"1 3 3";
}
