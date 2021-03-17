package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author 은서파
 * @since 2020. 3. 27.
 * @see
 * @mem dfs: 14476, greedy: 12944
 * @time dfs: 84, greedy: 72
 * @caution
 * 동전 교환과 같은 DP 문제로 보이지만 봉지가 단지 5와 3으로 되어있기 때문에 그리디하게 접근 가능
 */
/**
 * @author 은서파
 * @풀이일 2020. 3. 27.
 * @문제링크 https://www.acmicpc.net/problem/2839
 * @성능 그리디: 11468 76, dp: 11508 76
 * @분류
 * @고려사항
 * N이 매우 큰 문제로 재귀로 탐색하다 보면 시간 초과가 발생
 * 
 */
public class BJ_B1_2839_설탕배달_풀이 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int N, A;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());// (3 ≤ N ≤ 5000)
        A = Integer.MAX_VALUE;

        // dfs(N, 0);
        dp();
        System.out.println(A == Integer.MAX_VALUE ? -1 : A);
        // System.out.println(greedy());
    }

    static int greedy() {
        int cnt = 0;
        // 5로 나눠 떨어지는게 최선!! 나눠 떨어지지 않는다면 3씩 빼주자.
        while (N % 5 != 0) {
            cnt++;
            N -= 3;
        }
        // 이 과정에서 -로 떨어져버렸다면 --> 처리하지 못하는 것
        if (N >= 0) {
            cnt += N / 5;
            return cnt;
        } else {
            return -1;
        }
    }

    static void dp() {
        // 배달 불가 - 5kg 고려 시 +1을 하면 overflow가 발생하므로 Integer.MAX_VALUE를 사용하지 않는다.
        int INF = 987654321; // 배열에 들어갈 최대 값은 5000/3 정도이다.
        int[] memo = new int[N + 1];// i kg 일 경우 사용할 봉지의 개수

        // 밑밥 깔아주기 - 3kg 고려
        Arrays.fill(memo, INF);
        for (int i = 0; i < memo.length; i += 3) {
            memo[i] = i / 3;
        }

        // 5kg 봉지 고려
        // 현재의 케이스가 5키로 적었을 때보다 1봉지를 추가하는 게 더 적다면 바꾸자.
        for (int i = 5; i < memo.length; i++) {
            if (memo[i] > memo[i - 5] + 1) {
                memo[i] = memo[i - 5] + 1;
            }
        }

        A = memo[N] == INF ? -1 : memo[N];
    }

    // dfs 완전 탐색으로 그냥 계속 가면 시간 초과 발생
    static void dfs(int total, int cnt) {
        if (total == 0) {
            A = Math.min(cnt, A);
            return;
        } else if (total < 0) {
            return;
        } else if (cnt > A) {
            return;
        }
        // 계속 3, 5 씩 빼내본다.
        dfs(total - 5, cnt + 1);
        dfs(total - 3, cnt + 1);
    }

    private static String src = "11";
}
