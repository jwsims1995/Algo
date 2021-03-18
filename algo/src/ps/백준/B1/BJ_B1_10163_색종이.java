package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_10163_색종이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N;
	// 색종이를  표시할 배열 작성
	static int [][] map = new int[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		// 색종이 1<= N <= 100
		for (int n = 1; n <= N; n++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			// 변수 이름은 의미를 주세요.
			int sr = Integer.parseInt(tokens.nextToken());
			int sc = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			int h = Integer.parseInt(tokens.nextToken());
			
			// 입력 확인
			// System.out.println(sr + " : " +sc+ " : "+w+ " : "+ h);
			// 입력된 색종이 덮어쓰기
			for (int r = sr; r < sr+w; r++) {
				for (int c = sc; c < sc+h; c++) {
					map[r][c] = n;
				}
			}
		}// 입력 끝~
		
		// N장의 색종이 개수 세기
		int [] cnt = new int[N+1];
		
		for(int r =0; r<map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				cnt[map[r][c]]++;
			}
		}
		
		for (int i = 1; i < cnt.length; i++) {
			output.append(cnt[i]).append("\n");
		}
		System.out.println(output);
	}

	private static String src = "3\r\n" + "0 2 10 10\r\n" + "7 9 8 4\r\n" + "8 4 10 6";
}
