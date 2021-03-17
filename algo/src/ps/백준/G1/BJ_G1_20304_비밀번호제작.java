package ps.백준.G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 2. 10.
 * @see https://www.acmicpc.net/problem/20304
 * @mem 70548	
 * @time 536
 * @caution 
 * $BFS, $비트연산자, 
 * [고려사항] 
 * 자식 노드를 비트를 이용해서 안전거리 계산 후 사용하는 BFS 문제
 * [입력사항] [출력사항]
 */
public class BJ_G1_20304_비밀번호제작 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, M;
	static int[] attacks;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());

		attacks = new int[M];
		tokens = new StringTokenizer(input.readLine(), " ");
		for (int m = 0; m < M; m++) {
			attacks[m] = Integer.parseInt(tokens.nextToken());
		}
		// 입력 완료
		solution1();
		//solution2();
	}

	private static void solution2() {
		Queue<Integer> queue = new LinkedList<>();
		// 방문 처리 - 먼저 방문한 녀석들이 최소 안전거리인 녀석들
		boolean [] visited = new boolean[N+1];
		
		// 초기 큐 작업: 공격한 비번들을 Queue에 넣고 방문처리(안전거리 0)
		for(int m=0; m<M; m++) {
			queue.offer(attacks[m]);
			visited[attacks[m]]=true;
		}
		
		int depth = 0;
		while(!queue.isEmpty()) {
			// 현재 스냅샷으로 queue에 있는 넘들만 돌리고 새롭게 들어온 녀석들은 돌리면 안되!!
			int size = queue.size();
			while(size-->0) {
				// 1. 맨 앞에놈 가져오기
				int front = queue.poll();
				// 2. 필요한 작업이 있다면 한다.
				
				// 3. 자식 노드를 탐색해서 발견하면 queue에 추가한다.
				// 자식을 탐색하기 위해 1를 왼쪽으로 1씩 이동해가면서 비교하자.
				for(int i=1; i<=N; i<<=1) {
					// front와 비교하면서 front에 i가 담겨있다면 빼주고, 없다면 넣어주기.
					int next;
					/*
					if( (front & i) >0) { // 이미 해당 비트를 가지고 있다면?? --> 빼주자.
						//next = front & ~i;
						next = front -i;
					}else { // 해당 비트가 없기 때문에 넣어주자.
						//next = front | i;
						next = front + i;
					}
					*/
					next = front ^ i;
					
					// next가 이미 사용된(더 짧은 안전거리로 세팅된)경우나 범위는 넘어가면 아웃!
					if(next <=N && !visited[next]) {
						visited[next]=true;
						queue.offer(next);
					}
				}
			}
			//System.out.println(depth+" : "+queue);
			depth++;
		}
		System.out.println(--depth);
	}

	private static void solution1() {
		// 우리가 구할 것은 최대 안전거리 - 최소로 초기화
		int safeRate = Integer.MIN_VALUE;
		for (int n = 0; n <= N; n++) { // 1 000 000
			int MinSafeDist = Integer.MAX_VALUE;
			for (int m = 0; m < M; m++) { // 100 000 --> 너무 많이 돌아가서 이중for문 안될것 같다...
				int xor = n ^ attacks[m];
				int tempSafeDist = 0;
				//tempSafeDist = Integer.toBinaryString(xor).replaceAll("0", "").length(); //1만 세어본것.
				
				while(xor>0) {
					if( (xor & 1) >0) {
						tempSafeDist++;
					}
					xor >>= 1;
				}
				MinSafeDist = Math.min(MinSafeDist, tempSafeDist);
			}
			safeRate = Math.max(safeRate, MinSafeDist);
		}
		System.out.println(safeRate);
	}

	private static String src = "10\r\n" +
			"2\r\n" +
			"3 4";
}
