package ps.정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_1828_냉장고 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static Temp[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		temp = new Temp[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int l = Integer.parseInt(tokens.nextToken());
			int h = Integer.parseInt(tokens.nextToken());
			temp[n] = new Temp(l,h);
		}
//		System.out.println(Arrays.toString(temp));//입력확인
		Arrays.sort(temp);
	//	System.out.println(Arrays.toString(temp));//입력확인
		int cnt = 0;
		int low = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
				if(temp[i].low > low) {
					cnt++;
					low = temp[i].high;
			}
		}
		System.out.println(cnt);
	}

	static class Temp implements Comparable<Temp> {
		int low;
		int high;

		public Temp(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public String toString() {
			return "temp [low=" + low + ", high=" + high + "]";
		}

		@Override
		public int compareTo(Temp o) {
			return this.high - o.high;
		}

	}
}
