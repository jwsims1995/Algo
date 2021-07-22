package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_20055_컨베이어벨트위의로봇 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, cnt, time;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N= Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		LinkedList<Integer> queue =new LinkedList<>();
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < 2*N; n++) {
			int num = Integer.parseInt(tokens.nextToken());
			queue.add(num);
		}
		
		System.out.println(queue);
		
		while(true) {
			time++;
			System.out.println(time);
			int p = queue.pollLast();
			int origin = p;
			if(p>0) {
				p--; // 내구도가 있으면 로봇을 놓음으로써 내구도 --
				if(p==0)cnt++; // 내구도가 0이 되면 count
			}
			
			if(cnt == K) break; // 내구도 0인게 K개가 되면 종료
			
			
			if(queue.peek() > 0 && origin!=p) {
				int ahead = queue.poll();
				if(--ahead == 0) cnt++;
				queue.addFirst(ahead);
			}
			queue.addFirst(p); // 벨트는 계속 돌아감
			
			System.out.println(queue);
		}
		System.out.println(time);
	}
	
	
	
	static String src = "5 8\n" + 
			"100 99 60 80 30 20 10 89 99 100";
}
