package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_B1_2751_수정렬하기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int res[];
	static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		N = Integer.parseInt(input.readLine());
//		res = new int[N];
//		for (int n = 0; n < N; n++) {
//			res[n] = Integer.parseInt(input.readLine());
//		}
//		Arrays.sort(res);
//		for (int n = 0; n < N; n++) {
//			output.append(res[n] + "\n");
//		}
//		
//		System.out.println(output);
		N = Integer.parseInt(input.readLine());
		list = new ArrayList<Integer>();
		for (int n = 0; n < N; n++) {
			list.add(Integer.parseInt(input.readLine()));
		}
		Collections.sort(list);
		for (int n = 0; n < N; n++) {
			output.append(list.get(n) + "\n");
		}
		System.out.println(output);

	}
}
