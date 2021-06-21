package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2527_직사각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N,r,c, ans;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 1 ≤ N ≤ 15
		r = Integer.parseInt(tokens.nextToken()); // 0 ≤ r, c < 2N
		c = Integer.parseInt(tokens.nextToken());
		
		find(0,0,(int)Math.pow(2, N));
	}
	
	// 재귀를 짜면서 ... 같은 형태를 유지하면서 문제의 크기를 줄여가보자. 점점 줄이다가 크기가 1이 되면 그게 최종
	// 결정 요인 : 위치, 길이
	private static void find(int row, int col, int len) {
		// 언제 탐색이 종료? len == 1
		if(len == 1) {
			// 이 지점이 찾는 지점이면 종료
			if(row == r && col == c) {
				System.out.println(ans);
				System.exit(0);
			}
			// 탐색했으나 여기가 찾는 지점이 아냐...
			ans++;
			// 종료
			return;
		}
		// 어차피 안가봐도 될거?? 가지말기
		if(!(row <= r && r < row+len && col <= c && c < col +len)) {
			ans+= len * len;
			return;
		}
		
		// 재귀 상황
		// 1보다 크면? 4개로 쪼개서 다시 들어가기
		int nextLen = len/2; // 문제의 크기가 줄어든다
		find(row, col, nextLen);
		find(row, col + nextLen, nextLen);
		find(row + nextLen, col, nextLen);
		find(row + nextLen, col + nextLen, nextLen);
	}
	
	static String src = "2 3 1\r\n";
}
