package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B1_2999_비밀이메일 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		char[] in = input.readLine().toCharArray();
		
		int R=0,C =0;
		int cnt=0;
		for (int i = 1; i*i <= in.length; i++) {
			if(in.length % i == 0) R = Math.max(R, i);
		}
		C = in.length/R;
		char[][] arr= new char[R][C];
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				arr[r][c] = in[cnt++];
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				output.append(arr[r][c]);
			}
		}
		System.out.println(output);
	}
}
