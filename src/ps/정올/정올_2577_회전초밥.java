package ps.정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 정올_2577_회전초밥 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, D, K, C;
	static int[] dishesArr;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));

		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());	// 접시의 수
		D = Integer.parseInt(tokens.nextToken());	// 가짓수
		K = Integer.parseInt(tokens.nextToken());	// 연속해서 먹는 접시의 수
		C = Integer.parseInt(tokens.nextToken());	// 쿠폰 번호
		
		dishesArr = new int[N];
		
		for (int n = 0; n < N; n++) {
			dishesArr[n] = Integer.parseInt(input.readLine());
		}
		System.out.println(solve());
	}
	
	static int solve() {
		// 어떤 초밥을 몇개 먹었는지 관리할 배열
		int [] check = new int [D+1];
		// 쿠폰은 언제나 쓴다.
		check[C] = 1;
		int cnt = 1;// 먹은 초밥의 종류
		
		// 한번 먹어봅시다
		for (int k = 0; k < K; k++) {
			int dish = dishesArr[k];
			if(check[dish] == 0) { // 처음 먹어본 접시
				cnt++;
			}
			check[dish]++;
		}
		int max = cnt;
		
		for (int n = 0; n < N; n++) {
			// 맨 앞에 있는 접시는 안먹는걸로 --> check에서 1감소 --> 결과 0이 되어버리면? 종류가 줄어드는걸로
			int dish = dishesArr[n];
			check[dish]--;
			if(check[dish] == 0) {
				cnt--;
			}
			//새롭게 추가되는 접시는 먹는걸로
			dish = dishesArr[(n+K) % N];
			if(check[dish] ==0) {
				cnt++;
			}
			check[dish]++;
			max = Math.max(max, cnt);
		}
		return max;
		
		
	}
	private static String src = "8 30 4 30\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25";

}
