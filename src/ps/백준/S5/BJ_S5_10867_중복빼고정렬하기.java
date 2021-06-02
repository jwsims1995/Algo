package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_S5_10867_중복빼고정렬하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int arr[];
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			set.add(Integer.parseInt(tokens.nextToken()));
		}
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		System.out.println(list.toString().replace("[", "").replace(",","").replace("]", ""));
		
//		for (int i = 0; i < list.size(); i++) {
//			output.append(list.get(i)).append(" ");
//		}
//		System.out.println(output);
	}
	static String src = "10\r\n" + 
			"1 4 2 3 1 4 2 3 1 2";
}
