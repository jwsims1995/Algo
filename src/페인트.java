import java.io.IOException;
import java.util.Arrays;

public class 페인트 {

	static int N = 8;
	// 배열이 정확이 무엇을 저장하는지 잘 정하고 사용하자.
	// memo[n] : n 층을 칠할 수 있는 경우의 수.
	static long [] memo;
	public static void main(String[] args) throws IOException {
		// 모든 값은 여기로 모인다.
		memo = new long[N+1];
		// 기저 상황은 여기로 모여주세요.~~
		memo[1] = 2;
		memo[2] = 3;
		
		topDown(N);
		System.out.println(Arrays.toString(memo));
		bottomUp(N);
		
	}
	// 상향식 DP
	static long bottomUp(int n) {
		long [] dt = new long[n+1];
		// 기저상황
		dt[1] = 2;
		dt[2] = 3;
		
		for(int i=3; i<=n; i++) {
			dt[i] = dt[i-1] + dt[i-2];
		}
		System.out.println(Arrays.toString(dt));
		return dt[n];
	}
	
	// 하향식 DP(광의의 DP : 재귀 + memo)
	static long topDown(int n) {
		if(memo[n]>0) {
			// 이미 값이 구해진 경우는 그것을 사용하자.
			return memo[n];
		}

		return memo[n] = topDown(n - 1) + topDown(n - 2);
	}
	


}
