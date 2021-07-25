package ps.백준.S3;

import java.io.*;
import java.util.*;

public class BJ_S3_2805_나무자르기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, sum, ans;
	static int[] num;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
		
	});
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // N개 나무
		M = Integer.parseInt(tokens.nextToken()); // M만큼 들고감
		num = new int[N];
		tokens =new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			pq.add(Integer.parseInt(tokens.nextToken()));
		}
		
		while(sum<M) { 		
			pq.offer(pq.poll() -1);
			sum++;
		}

		
		System.out.println(pq.poll());
	}

	static String src = "5 20\n" + 
			"4 42 40 26 46";
}
