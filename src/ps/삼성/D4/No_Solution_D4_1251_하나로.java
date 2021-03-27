package ps.삼성.D4;

import java.io.*;
import java.util.*;

public class Solution_D4_1251_하나로 {
	static class Node{
		int to;
		long weight;
		Node(int to, long weight){
			this.to = to; this.weight = weight;
		}
	}
	
	public long Prim(List<List<Node>> graph) {
		boolean[] v = new boolean[graph.size()];
		long[] minEdge = new long[graph.size()];
		Arrays.fill(minEdge, Long.MAX_VALUE);
		
		int minVertex;
		long min, result = 0;
		minEdge[0] = 0;
		
		for(int c = 0; c < graph.size(); c++) {
			min = Long.MAX_VALUE;
			minVertex = 0;
			
			for(int i = 0; i < graph.size(); i++) {
				if(!v[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			result += min;
			v[minVertex] = true;
			
			for(int i = 0; i < graph.get(minVertex).size(); i++) {
				Node next = graph.get(minVertex).get(i);
				if(!v[next.to] && next.weight < minEdge[next.to]) {
					minEdge[next.to] = next.weight;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		No_Solution_D4_1251_하나로 s = new No_Solution_D4_1251_하나로();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++ ) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			long[] x = new long[N];
			long[] y = new long[N];
			List<List<Node>> graph = new ArrayList<>();
			for(int i = 0; i < N; i++) graph.add(new ArrayList<>());
			
			for(int i = 0 ; i < N; i++) x[i] = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < N; i++) y[i] = Long.parseLong(st.nextToken());
			
			double E = Double.parseDouble(br.readLine());

			// 그래프 만들기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					graph.get(i).add(new Node(j, (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j])));
				}
			}
			bw.write("#" + tc + " " + Math.round(E * s.Prim(graph)) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}