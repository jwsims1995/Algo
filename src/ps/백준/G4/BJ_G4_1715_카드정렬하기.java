package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G4_1715_카드정렬하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, sum, ans;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	});
	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(input.readLine());
			pq.add(num);
		}
			//40 20 10 --> 10 + 20 + (10+20) + 40
			// 40 30 20 10 --> 10 + 20 + (10+20) + 30 + 60 + 40
		int sum =0;
//		System.out.println(pq);

		while(pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			sum+= a+b;
			pq.add(a+b);
		}
		System.out.println(sum);
		
	}
	static String src = "3\r\n" + 
			"10\r\n" + 
			"20\r\n" + 
			"40";
}
