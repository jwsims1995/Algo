
public class 막대 {
	static int N = 6;
	// n cm를 채우는 방법의 수
	static long[] memo;

	public static void main(String[] args) {
		memo = new long[N + 1];
		memo[0] = 1; // R:0, B:0, Y:0
		memo[1] = 2;
		// memo[2] = 5;
		System.out.println(topDown(N));
		System.out.println(bottomUp(N));
		System.out.println(bottomUp2(N));
	}

	static long bottomUp2(int n) {
		// n cm를 마지막에 x컬러로 채우는 경우의 수 0: B, 1: Y, 2:R
		long[][] dp = new long[n + 1][3];
		// 0 cm인 경우는 예외 상황으로 처리
		// 기저조건
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 0;

		dp[2][0] = dp[1][0] + dp[1][1] + dp[1][2];
		dp[2][1] = dp[1][0] + dp[1][1] + dp[1][2];
		dp[2][2] = 1; // 점화식으로 채울 수 없는 부분이 나올 때까지는 생각을 해줘야한다.

		for (int i = 3; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
			dp[i][1] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
			dp[i][2] = dp[i - 2][0] + dp[i - 2][1] + dp[i - 2][2];
		}
		return dp[n][0] + dp[n][1] + dp[n][2];
	}

	// 재귀 + 메모
	static long topDown(int n) {
		if (memo[n] > 0) {
			return memo[n];
		}
		return memo[n] = topDown(n - 1) * 2 + topDown(n - 2);
	}

	static long bottomUp(int n) {
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 2;
		// dp[2] = 5;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] * 2 + dp[i - 2];
		}
		return dp[n];
	}

}
