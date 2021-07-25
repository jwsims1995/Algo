package ps.백준.G2;

import java.io.*;
import java.util.*;

public class BJ_G2_1202_보석도둑2 {

	static class Jewel implements Comparable<Jewel> {
		int weight, price;

		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jewel o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Jewel [weight=" + weight + ", price=" + price + "]";
		}

	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, sum;
	static Jewel[] jewels;
	static int[] bag;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		jewels = new Jewel[N];
		bag = new int[K];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		}); 
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int weight = Integer.parseInt(tokens.nextToken());
			int price = Integer.parseInt(tokens.nextToken());
			jewels[n] = new Jewel(weight, price);
		}
		for (int k = 0; k < K; k++) {
			bag[k] = Integer.parseInt(input.readLine());
		} // 입력완료

		Arrays.sort(jewels);
		Arrays.sort(bag);

//		System.out.println(Arrays.toString(jewels));
//		System.out.println(Arrays.toString(bag));
		
		for (int k = 0, cnt = 0; k < K; k++) {
			while (cnt < N && bag[k] >= jewels[cnt].weight) {
				pq.offer(jewels[cnt++].price);
			}
			//System.out.println(pq);
			if(!pq.isEmpty()) {
				sum+=pq.poll();
			}
		}
		
		
		System.out.println(sum);
	}

	static String src = "3 2\r\n" + "1 65\r\n" + "5 23\r\n" + "2 99\r\n" + "10\r\n" + "2";
}
