package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S4_11508_2플러스1세일 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, sum;
	static List<Integer> product = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		for(int n=0; n<N; n++) {
			product.add(Integer.parseInt(input.readLine()));
		}
		Collections.sort(product, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
//		System.out.println(product);
		int size = N/3;
		for(int i=0; i<size; i++) {
			sum += product.remove(0) + product.remove(0);
			product.remove(0);
		}
		while(!product.isEmpty()) {
			sum+=product.remove(0);
		}
		System.out.println(sum);
	}
	static String src = "6\n" + 
			"6\n" + 
			"4\n" + 
			"5\n" + 
			"5\n" + 
			"5\n" + 
			"5";
}
