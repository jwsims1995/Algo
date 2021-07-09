package ps.백준.G2;

import java.io.*;
import java.util.*;

public class BJ_G2_1202_보석도둑 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static class Jewel implements Comparable<Jewel> {
		int weight, price;

		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jewel o) {
			if (this.weight == o.weight)
				return o.price - this.price;
			// return Integer.compare(this.weight, o.weight);
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Jewel [weight=" + weight + ", price=" + price + "]";
		}
		
	}

	static int N, K, ans;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		Jewel[] jewels = new Jewel[N];
		int[] bag = new int[K];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int weight = Integer.parseInt(tokens.nextToken());
			int price = Integer.parseInt(tokens.nextToken());
			jewels[n] = new Jewel(weight, price);
		}
		for (int k = 0; k < K; k++) {
			bag[k] = Integer.parseInt(input.readLine());// 수용가능무게
		}
		System.out.println(Arrays.toString(jewels));
		Arrays.sort(jewels);
		System.out.println(Arrays.toString(jewels));
		System.out.println(Arrays.toString(bag));

		Arrays.sort(bag);
		System.out.println(Arrays.toString(bag));

		// System.out.println(Arrays.toString(bag));
		// System.out.println(bag);

		for (int k = 0, cnt = 0; k < K; k++) {
			while (cnt < N && bag[k] >= jewels[cnt].weight) {
				pq.offer(jewels[cnt++].price);
			}

			if (!pq.isEmpty())
				ans += pq.poll();
		}
		// System.out.println(pq);
		System.out.println(ans);
	}

	static String src = "2 3\r\n" + "5 10\r\n" + "4 100\r\n" + "11\r\n" + "13\r\n" + "9";
}
