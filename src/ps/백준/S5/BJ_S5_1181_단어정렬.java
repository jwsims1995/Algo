package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S5_1181_단어정렬 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static String[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new String[N];
		for (int n = 0; n < N; n++) {
			arr[n] = input.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())return o1.compareTo(o2);
				return o1.length() - o2.length();
			}
		});
		
		output.append(arr[0] + "\n");
		for (int i = 1; i < arr.length; i++) {
			if( arr[i].equals(arr[i-1])  ) continue;
			output.append(arr[i] + "\n");		
		}
		System.out.println(output);
	}
	static String src = "13\r\n" + 
			"but\r\n" + 
			"i\r\n" + 
			"wont\r\n" + 
			"hesitate\r\n" + 
			"no\r\n" + 
			"more\r\n" + 
			"no\r\n" + 
			"more\r\n" + 
			"it\r\n" + 
			"cannot\r\n" + 
			"wait\r\n" + 
			"im\r\n" + 
			"yours";
}
