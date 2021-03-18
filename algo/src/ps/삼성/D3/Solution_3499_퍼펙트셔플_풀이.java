package ps.삼성.D3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 2. 5.
 * @see
 * @mem
 * @time
 * @caution [고려사항] [입력사항] [출력사항]
 */
public class Solution_3499_퍼펙트셔플_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T, N;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			// token에서 넘어오는게 전체 덱
			tokens = new StringTokenizer(input.readLine());

			Queue<String> left = new LinkedList<>();
			Queue<String> right = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				// 절반보다 0.5장 더 가져간다는 느낌?
				if (i < (N + 1) / 2) {
					left.offer(tokens.nextToken());
				} else {
					right.add(tokens.nextToken());
				}
			}
			output.append("#").append(t).append(" ");
			// 왼쪽에서 한장, 오른쪽에서 한장...
			while (!left.isEmpty()) {
				output.append(left.poll()).append(" ");
				if (!right.isEmpty()) {
					output.append(right.poll()).append(" ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	static String src = "3\r\n" +
			"6\r\n" +
			"A B C D E F\r\n" +
			"4\r\n" +
			"JACK QUEEN KING ACE\r\n" +
			"5\r\n" +
			"ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";
}
