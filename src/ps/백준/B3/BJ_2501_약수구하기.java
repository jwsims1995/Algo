package ps.백준.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BJ_2501_약수구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input  = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(N);
		for(int n=2; n<=N/2; n++) {
			if(N%n==0) list.add(n);
		}
		Collections.sort(list);
//		System.out.println(list);
		int size = list.size();
		if(size < K) {
			System.out.println(0);
			System.exit(0);
		}
		System.out.println(list.get(K-1));
		
	}
	static String src = "2735 1";
}
