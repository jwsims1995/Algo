package ps.정올.Beginner.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1338_문자삼각형1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, cnt;

	// 'A' = 65
	static char[][] arr;
	static char alpha = 'A';

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine()); // 1이상 100이하
		arr = new char[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(arr[i], ' ');			
		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = i, k=N; j <= N; j++,k--) {
//				arr[j][k] = alpha++;
//				if(alpha > 'Z') alpha = 'A';
//			}
//		}
////		for (char[] c : arr) {
////			System.out.println(Arrays.toString(c));
////		}
//		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if(arr[i][j] == ' ') output.append(" ");
//				else output.append(arr[i][j]).append(" ");
//			}
//			output.append("\n");
//		}
//		System.out.println(output);
		int or = 1;
		int oc = N;
		int r = or;
		int c = oc;
		while (true) {
			if (or == N+1)
				break;
			
			arr[r++][c--] = alpha++;
			if(alpha > 'Z') alpha = 'A';
			
			if (!isIn(r,c)) {
				or++;
				r = or;
				c = oc;
			}
		}
		//arr[r][c] = alpha;
		//출력
//		for (char[] ch : arr) {
//			System.out.println(Arrays.toString(ch));
//		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
//				if (arr[i][j] == ' ')
//					output.append("  ");
//				else
					output.append(arr[i][j]).append(" ");
			}
			output.append("\n");
		}
		System.out.print(output);
	}

	private static boolean isIn(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
}
