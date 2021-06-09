package ps.정올.Beginner.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2809_약수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		for (int n = 1; n*n <= N; n++) {
			if(N%n == 0) {
				list.add(n);
				if(n != N/n) list.add(N/n);
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d ", list.get(i));
		}
	}
}
