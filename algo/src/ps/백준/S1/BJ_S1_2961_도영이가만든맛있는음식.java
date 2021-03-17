package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 15.
 * @author Jaewon
 * @see https://www.acmicpc.net/problem/2961
 * @mem
 * @time
 * @caution
 */

public class BJ_S1_2961_도영이가만든맛있는음식 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, answer;
	static Food[] foods;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		foods = new Food[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int S = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());

			foods[n] = new Food(S, B);
		}
//		System.out.println(Arrays.toString(foods));//입력완료
		answer = Integer.MAX_VALUE;
		powerSet(N, new boolean[N]);
		System.out.println(answer);
		///////
	}

	private static void powerSet(int toChoose, boolean[] choosed) {
		if (toChoose == 0) {
			print(choosed);
			return;
		}
		choosed[choosed.length - toChoose] = true;
		powerSet(toChoose - 1, choosed);
		choosed[choosed.length - toChoose] = false;
		powerSet(toChoose - 1, choosed);
	}

	private static void print(boolean[] choosed) {
		int sMul = 1;
		int bSum = 0;
		
		List<Food> list = new ArrayList<Food>();
		List<Integer> s = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < choosed.length; i++) {
			if(choosed[i]) {
//				list.add(foods[i]);
				sMul *= foods[i].s;
				bSum += foods[i].b;
//				s.add(foods[i].s);
//				b.add(foods[i].b);
			}
		}
//		System.out.println(list);
//		System.out.println("신맛 :" + s);
//		System.out.println("쓴맛 :" + b);
//		System.out.println("신맛 곱 : " + sMul);
//		System.out.println("쓴맛 합 : " + bSum);
//		System.out.println();
		if(bSum != 0) {
			answer = Math.min(answer, Math.abs(sMul- bSum));
		}
//		System.out.println(answer);
	}

	static class Food {
		int s;
		int b;

		public Food(int s, int b) {
			super();
			this.s = s;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Food [s=" + s + ", b=" + b + "]";
		}

	}
}
