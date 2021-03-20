package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 21.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class BJ_B2_2920_음계 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr = new int[8];
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());			
		}
		System.out.println(sort(arr));
		
	}
	private static String sort(int[] arr) {
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == arr[i+1] - 1)
				result = "ascending";
			else if(arr[i] == arr[i+1] + 1)
				result = "descending";
			else {
				result =  "mixed";
				break;
			}
		}
		
		return result;
		
	}

}
