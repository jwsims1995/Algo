package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 8.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution 부분집합
 */

public class Solution_5215_햄버거다이어트_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, L, answer;
	static Material [] ms;
	static int MAX_SAT;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			L = Integer.parseInt(tokens.nextToken());

			ms = new Material[N];
			for (int n = 0; n < N; n++) {
				tokens = new StringTokenizer(input.readLine());
				int sat = Integer.parseInt(tokens.nextToken());
				int cal = Integer.parseInt(tokens.nextToken());
				ms[n] = new Material(sat, cal);
			}
			//System.out.println(Arrays.toString(ms));
			//입력완료
			
			// 특히 공유 변수를 사용하고 있을 때는 값을 초기화 잘 해주자.
			MAX_SAT = 0;
			subSsetBypPermutation(N, 0, 0);;
			//System.out.println(MAX_SAT);
			output.append(String.format("#%d %d%n ", t, MAX_SAT));
		}
		System.out.println(output);
	}
	//어떤녀석이 뽑혔는지(Choosed[]) 가 아니라 여기까지 뽑았을때 만족도와 칼로리가 관심사.
	static void subSsetBypPermutation(int toChoose, int sat, int cal) {
		//혹시 지금까지의 칼로리가 max cal를 넘었나? 
		//쓸데없는 길은 가지말자 !! 가 point
		if(cal > L) {
			return;
		}
		if(toChoose==0) {
			//다 뽑았다. 결과를 출력하자.
			MAX_SAT = Math.max(MAX_SAT, sat);
			return;
		}
		//다음꺼 탐색...
		// 하나를 뽑았다.
		int idx = N-toChoose;
		// 기존의 만족도 + 이번에 새로 뽑은 녀석의 만족도
		subSsetBypPermutation(toChoose-1, sat + ms[idx].sat, cal +ms[idx].cal);//그 재료를 썼을때
		subSsetBypPermutation(toChoose-1, sat, cal);//안썼을때
	}

	static class Material {
		int sat;
		int cal;

		public Material(int sat, int cal) {
			super();
			this.sat = sat;
			this.cal = cal;
		}

		@Override
		public String toString() {
			return "Material [sat=" + sat + ", cal=" + cal + "]";
		}
	}
}
