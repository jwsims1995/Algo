package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_1931_회의실배정 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[] start, end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		int cnt = 0;
		start = new int[N];
		end = new int[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			start[n] = Integer.parseInt(tokens.nextToken());
			end[n] = Integer.parseInt(tokens.nextToken());
			
			
		}
	}
}
