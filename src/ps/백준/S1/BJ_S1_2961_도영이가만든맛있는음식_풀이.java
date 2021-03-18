package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @풀이일 2020. 8. 5
 * @문제링크 https://www.acmicpc.net/problem/2961
 * @성능 비트마스킹: 11500 kb 76 ms, 중복순열: 11500 80
 * @분류 $부분집합,
 * @고려사항 최소 하나는 선택되어야 한다.
 */
public class BJ_S1_2961_도영이가만든맛있는음식_풀이 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static Material[] materials;
	static int min;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		materials = new Material[N];

		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			materials[n] = new Material(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
		}
		min = Integer.MAX_VALUE;
		makeSubset();
		// powerSetDup(N, new boolean[N]);
		//powerSetDup(N, 0, 1, 0);
		System.out.println(min);
	}

	static void makeSubset() {
		// 최소 하나는 선택되어야 하므로 공집합은 제외
		for (int i = 1; i < (1 << N); i++) {
			int totalT1 = 1;
			int totalT2 = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					totalT1 *= materials[j].t1;
					totalT2 += materials[j].t2;
				}
			}
			min = Math.min(min, Math.abs(totalT1 - totalT2));
		}
	}

	// 단순히 한번 찾아본다면...
	static void powerSetDup(int toChoose, boolean[] choosed) {
		if (toChoose == 0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		choosed[N - toChoose] = true;
		powerSetDup(toChoose - 1, choosed);
		choosed[N - toChoose] = false;
		powerSetDup(toChoose - 1, choosed);
	}

	static void powerSetDup(int toChoose, int selectedCnt, int t1, int t2) {
		if (toChoose == 0) {
			// 최소한 하나는 선택되어야 한다.
			if (selectedCnt != 0) {
				min = Math.min(min, Math.abs(t1 - t2));
			}
			return;
		}
		// 선택한 경우
		Material m = materials[N - toChoose];
		// choosed[choosed.length-toChoose]=true;
		powerSetDup(toChoose - 1, selectedCnt + 1, t1 * m.t1, t2 + m.t2);
		// 선택하지 않은 경우
		// choosed[choosed.length-toChoose]=false;
		powerSetDup(toChoose - 1, selectedCnt, t1, t2);
	}

	static class Material {
		int t1;
		int t2;

		public Material(int tS, int tB) {
			super();
			this.t1 = tS;
			this.t2 = tB;
		}
	}

	private static String src = "4\r\n" + "1 7\r\n" + "2 6\r\n" + "3 8\r\n" + "4 9";
}
