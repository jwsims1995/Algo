package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * @author 은서파
 * @풀이일 2019. 4. 2.
 * @문제링크 https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0&categoryId=AWgv9va6HnkDFAW0&categoryType=CODE
 * @성능 재귀 순열: 21,784 kb, 2,205 ms, 재귀순열(불필요 제거): 21,660 kb 1,242 ms, NP
 *     순열:23,452 kb, 721 ms
 * @분류 $순열
 * @고려사항 boolean [] visited를 쓰건 int status를 쓰건 시간은 비슷 규영이 카드가 주어졌을 때 인영이 카드의 순서를
 *       변경해가면서 대조해서 계산해보는 순열 문제
 */
public class Solution_6808_규영이와인영이의카드게임_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	private static int[] kyDeck = new int[9];
	private static int[] iyDeck = new int[9];
	private static int kyWin, iyWin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			Set<Integer> strs = new HashSet<>();
			for (int i = 0; i < kyDeck.length; i++) {
				kyDeck[i] = Integer.parseInt(tokens.nextToken());
				strs.add(kyDeck[i]);
			}

			for (int i = 1, ii = 0; i <= kyDeck.length * 2; i++) {
				if (!strs.contains(i)) {
					iyDeck[ii++] = i;
				}
			}
			// System.out.println("규영 카드:" + Arrays.toString(kyDeck));
			// System.out.println("인영 카드:" + Arrays.toString(iyDeck));
			// 입력 완료

			// 정답에 대한 초기화
			kyWin = 0;
			iyWin = 0;
			// 이제 선택된 9장의 카드를 이용해서 순열을 구해보자.
			// permutation(iyDeck.length, new int[iyDeck.length], new
			// boolean[iyDeck.length]);
			// permutation(iyDeck.length, new boolean[iyDeck.length], 0, 0);
			// permutation(iyDeck.length, 0, 0, 0);
			byNp();
			output.append(String.format("#%d %d %d%n", t, kyWin, iyWin));
		}
		System.out.println(output);
	}

	static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if (toChoose == 0) {
			// System.out.println(Arrays.toString(choosed));
			check(choosed);
			return;
		}

		for (int i = 0; i < iyDeck.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[choosed.length - toChoose] = iyDeck[i];
				permutation(toChoose - 1, choosed, visited);
				visited[i] = false;
			}
		}
	} // 18장 카드의 중간 값: 18*19/2= 171/2 = 85

	static void permutation(int toChoose, boolean[] visited, int kyScore, int iyScore) {
		// 이 가지치기 block이 없으면 2000ms 정도
		if (kyScore > 85 || iyScore > 85) {
			// 남은 선택회수를 계산해서 더해줘버리기 ex) 5*4*3*2*1
			int remain = 1;
			for (int i = toChoose; i > 0; i--) {
				remain *= i;
			}
			if (kyScore > iyScore) {
				kyWin += remain;
			} else if (kyScore < iyScore) {
				iyWin += remain;
			}
			return;
		}
		// 가지치기 끝

		if (toChoose == 0) {
			if (kyScore > iyScore) {
				kyWin++;
			} else if (kyScore < iyScore) {
				iyWin++;
			}
			return;
		}

		for (int i = 0; i < iyDeck.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				// choosed[choosed.length - toChoose] = iyDeck[i];
				if (kyDeck[i] > iyDeck[iyDeck.length - toChoose]) {
					permutation(toChoose - 1, visited, kyScore + kyDeck[i] + iyDeck[iyDeck.length - toChoose], iyScore);
				} else {
					permutation(toChoose - 1, visited, kyScore, iyScore + kyDeck[i] + iyDeck[iyDeck.length - toChoose]);
				}
				visited[i] = false;
			}
		}
	}

	// 18장 카드의 중간 값: 18*19/2= 171/2 = 85
	static void permutation(int toChoose, int status, int kyScore, int iyScore) {
		if (kyScore > 85 || iyScore > 85) {
			// 남은 선택회수를 계산해서 더해줘버리기 ex) 5*4*3*2*1
			int remain = 1;
			for (int i = toChoose; i > 0; i--) {
				remain *= i;
			}
			if (kyScore > iyScore) {
				kyWin += remain;
			} else if (kyScore < iyScore) {
				iyWin += remain;
			}
			return;
		}

		if (toChoose == 0) {
			if (kyScore > iyScore) {
				kyWin++;
			} else if (kyScore < iyScore) {
				iyWin++;
			}
			return;
		}

		for (int i = 0; i < iyDeck.length; i++) {
			// 아직 없는 상태라면..
			if ((status & 1 << i) == 0) {
				// choosed[choosed.length - toChoose] = iyDeck[i];
				if (kyDeck[i] > iyDeck[iyDeck.length - toChoose]) {
					permutation(toChoose - 1, status | 1 << i, kyScore + kyDeck[i] + iyDeck[iyDeck.length - toChoose],
							iyScore);
				} else {
					permutation(toChoose - 1, status | 1 << i, kyScore,
							iyScore + kyDeck[i] + iyDeck[iyDeck.length - toChoose]);
				}
			}
		}
	}

	static void check(int[] choosed) {
		int kyScore = 0, iyScore = 0;
		for (int i = 0; i < choosed.length; i++) {
			// 카드는 같을 수 없다.
			if (kyDeck[i] > choosed[i]) {
				kyScore += kyDeck[i] + choosed[i];
			} else {
				iyScore += kyDeck[i] + choosed[i];
			}
		}
		// 점수는 같을 수 있으므로 주의~~
		if (kyScore > iyScore) {
			kyWin++;
		} else if (kyScore < iyScore) {
			iyWin++;
		}
	}

	static void byNp() {
		Arrays.sort(iyDeck);
		do {
			check(iyDeck);
		} while (nextPermutation());
	}

	static boolean nextPermutation() {
		int i = iyDeck.length - 1;
		while (i > 0 && iyDeck[i - 1] >= iyDeck[i]) {
			i--;
		}
		// i를 발견하지 못했다면.. 자리를 바꿀 녀석이 없고 다음 순열은 없는 것
		if (i == 0) {
			return false;
		}
		int j = iyDeck.length - 1;
		while (iyDeck[i - 1] >= iyDeck[j]) {
			j--;
		}
		// i와 j 자리 바꾸기
		swap(i - 1, j);

		// i 뒤에 있는 녀석들 reverse 시키기
		int k = iyDeck.length - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	static void swap(int a, int b) {
		int temp = iyDeck[a];
		iyDeck[a] = iyDeck[b];
		iyDeck[b] = temp;
	}

	static String src = "4\n" + "1 3 5 7 9 11 13 15 17\n" + "18 16 14 12 10 8 6 4 2\n" + "13 17 9 5 18 7 11 1 15\n"
			+ "1 6 7 9 12 13 15 17 18";
}