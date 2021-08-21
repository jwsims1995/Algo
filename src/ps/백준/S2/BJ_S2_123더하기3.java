package ps.백준.S2;

import java.io.*;
import java.util.*;

public class BJ_S2_123더하기3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, num, ans;
	static int[] info = { 1, 2, 3 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());

		for (int n = 0; n < N; n++) {
			ans = 0;
			num = Integer.parseInt(input.readLine());
			perm(0);
			output.append(ans).append("\n");
		}
		System.out.println(output);
	}

	private static void perm(int sum) {
		if (sum > num)
			return;
		if (sum == num) {
			ans++;
			return;
		}

		for (int i = 0; i < info.length; i++) {
			perm(sum + info[i]);
		}
	}

	static String src = "3\r\n" + "4\r\n" + "7\r\n" + "10";
}
