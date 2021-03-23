package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 22.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

// 일반 : 107904	1772, PQ: 108880	628

public class BJ_G5_1753_최단경로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int V, E, K;
	static LinkNode[] graph;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(), " ");
		V = Integer.parseInt(tokens.nextToken()) + 1;// 모든 정점은 1번부터 시작, 정점의 개수는 최대 200000.
		E = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(input.readLine());

		graph = new LinkNode[V];
		for (int e = 0; e < E; e++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			// 단방향 그래프
			graph[a] = new LinkNode(b, w, graph[a]);
		}
		/*
		 * for(LinkNode node: graph) { System.out.println(node); }
		 */
		// 입력 종료
		 dijkstra(K);
		//dijkstraPQ(K);
	}

	static void dijkstraPQ(int start) {
		// 상황판.
		boolean[] visited = new boolean[V];
		int[] dist = new int[V];
		int inf = 987654321;
		Arrays.fill(dist, inf);
		PriorityQueue<LinkNode> pq = new PriorityQueue<>();

		// 출발지 선정
		dist[start] = 0;
		pq.add(new LinkNode(start, 0, null));

		while (!pq.isEmpty()) {
			// 한녀석을 뽑으면 그게 최소
			LinkNode head = pq.poll();
			if (visited[head.i]) {
				//System.out.println("넌 이미 왔었잖아....");
				continue;
			}
			// 방문 처리
			visited[head.i] = true;

			// 자식 탐색
			LinkNode child = graph[head.i];
			//System.out.println(child);
			while (child != null) {
				if (!visited[child.i] && dist[child.i] > dist[head.i] + child.c) {
					dist[child.i] = dist[head.i] + child.c;
					// head를 넣어주면 손쉽게 경로를 역추적 할 수 있다..
					pq.add(new LinkNode(child.i, dist[child.i], head));
				}
				child = child.pre;
			}
		} // pq 동작 완료
		//System.out.println(Arrays.toString(dist));
		for (int i = 1; i < V; i++) {
			if (dist[i] == inf) {
				output.append("INF");
			} else {
				output.append(dist[i]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	static void dijkstra(int start) {
		// 잘 동작하고 있는지 점검할 상황판~~
		boolean[] visited = new boolean[V];
		int[] dist = new int[V];// 누적 거리를 기록할 배열 --> 여기 등록된 값을 최대한 줄여보자.
		// 일단은 미지의 세계
		int inf = 987654321; // Integer.MAX_VALUE를 하지 않는 이유는 inf+x 같은 코드가 나올 경우 대비
		Arrays.fill(dist, inf);

		// 탐색의 시작
		// 출발점의 누적 비용은 언제나 0
		dist[start] = 0;

		// 모든 정점의 개수만큼 탐색이 이뤄진다.
		for (int v = 0; v < V; v++) {
			// 최소 누적 비용 정점과 그때의 비용은?
			int minVer = 0, minCost = inf;
			for (int i = 1; i < V; i++) {
				// 이직 미방문이고 거기로 가는 누적 비용이 minCost보다 작다면......
				if (!visited[i] && dist[i] < minCost) {
					minVer = i;
					minCost = dist[i];
				}
			}
			// 탐색 지점이 결정되었다!!!! --> 방문 처리
			visited[minVer] = true;
			// 다음 자식을 찾아가보자.
			LinkNode child = graph[minVer];
			while (child != null) {
				// 자식 중 아직 미방문이고 거쳐서 갔더니 누적 비용이 오히려 더 싸진 지점..
				if (!visited[child.i] && dist[child.i] > dist[minVer] + child.c) {
					dist[child.i] = dist[minVer] + child.c;
				}
				child = child.pre;
			}
		} // dijkstra 탐색
			// System.out.println(Arrays.toString(dist));
		for (int i = 1; i < V; i++) {
			if (dist[i] == inf) {
				output.append("INF");
			} else {
				output.append(dist[i]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	// PQ에서 관리하기 위해서 Comparable 하게 만들자.
	static class LinkNode implements Comparable<LinkNode> {
		int i, c; // 번호와 비용
		LinkNode pre; // 이전 노드 정보

		public LinkNode(int i, int c, LinkNode pre) {
			super();
			this.i = i;
			this.c = c;
			this.pre = pre;
		}

		@Override
		public String toString() {
			return "[i=" + i + ", c=" + c + ", pre=" + pre + "]";
		}

		@Override
		public int compareTo(LinkNode o) {
			return Integer.compare(this.c, o.c);
		}
	}

	static String src = "5 6\r\n" +
			"1\r\n" +
			"5 1 1\r\n" +
			"1 2 2\r\n" +
			"1 3 3\r\n" +
			"2 3 4\r\n" +
			"2 4 5\r\n" +
			"3 4 6";
}
