package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_3040_백설공주와일곱난쟁이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N = 9;
	static int SUM = 100;
	static int sum;
	static int[] dwarf = new int[9];
	static int[] answer = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int n = 0; n < N; n++) {
			dwarf[n] = Integer.parseInt(input.readLine());
		}
//		System.out.println(Arrays.toString(dwarf));//입력완료
		combination(7,new int[7], 0);
		for (int s : answer) {
			System.out.println(s);
		}
	}
	private static void combination(int toChoose, int[] choosed, int idx) {
		if(toChoose == 0) {
			//System.out.println(Arrays.toString(choosed));
			for (int i = 0; i < choosed.length; i++) {
				sum+=choosed[i];
			}
			//System.out.println(sum);
			if(sum == SUM) {
				for (int i = 0; i < choosed.length; i++) {
					answer[i] = choosed[i];
				}
			}
			sum = 0;
			return;
		}
		for (int i = idx; i < dwarf.length; i++) {
			choosed[choosed.length - toChoose] = dwarf[i];
			combination(toChoose-1, choosed, i+1);
		}
	}
	
}
