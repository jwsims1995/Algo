package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.StringReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class BJ_B2_2309_일곱난쟁이 {
//	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//	static StringBuilder output = new StringBuilder();
//	static StringTokenizer tokens;
//	static int[] nine = new int[9];
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
//		for (int n = 0; n < nine.length; n++) {
//			nine[n] = Integer.parseInt(input.readLine());
//		}
//		combination(7, new int[7], 0);
//	}
//
//	private static void combination(int toChoose, int[] choosed, int idx) {
//		if (toChoose == 0) {
//			int sum = 0;
//			for (int i = 0; i < choosed.length; i++) {
//				sum += choosed[i];
//			}
//			if (sum == 100) {
//				Arrays.sort(choosed);
//				for (int i = 0; i < choosed.length; i++) {
//					System.out.println(choosed[i]);
//				}
//			}
//			return;
//		}
//		for (int i = idx; i < nine.length; i++) {
//			choosed[choosed.length - toChoose] = nine[i];
//			combination(toChoose - 1, choosed, i + 1);
//		}
//	}
//
//	static String src = "20\r\n" + "7\r\n" + "23\r\n" + "19\r\n" + "10\r\n" + "15\r\n" + "25\r\n" + "8\r\n" + "13";
//}

public class BJ_B2_2309_일곱난쟁이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[] dwarf = new int[9];
	static int[] ans = new int[7];
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int n = 0; n < dwarf.length; n++) {
			dwarf[n] = Integer.parseInt(input.readLine());
		}

		int sum = 0;
		for (int i = 0; i < dwarf.length; i++) {
			sum += dwarf[i];
		}

		for (int i = 0; i < dwarf.length; i++) {
			for (int j = i + 1; j < dwarf.length; j++) {
				if (dwarf[i] + dwarf[j] == sum - 100) {
					int cnt = 0;
					for (int k = 0; k < dwarf.length; k++) {
						if (k == i || k == j)
							continue;
						ans[cnt++] = dwarf[k];
					}
					Arrays.sort(ans);
					
					for (int c = 0; c < cnt; c++) {
						System.out.println(ans[c]);
					}
					System.exit(0);
				}
			}
		}
	}
}
