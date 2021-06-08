package ps.정올.Beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1339_문자삼각형2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, cnt;
	static char[][] arr;
	static char alpha = 'A';
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		if(1>N || N>100 || N%2==0) {
			System.out.println("INPUT ERROR");
			return;
		}
		
		arr=  new char[N][N/2+1];
		for (int j = 0; j < N; j++) {
			Arrays.fill(arr[j], ' ');
		}
		int r = N/2;
		int or = r-1;
		int c = N/2;
		while(true) {
			if(r == N) break;

			if(r+c == N) {
				r=or--;
				c--;
			}
			arr[r][c] = alpha++;
			r++;
			
			if(alpha > 'Z')alpha = 'A';
			}
//		for (char[] row : arr) {
//			System.out.println(Arrays.toString(row));
//		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N/2+1; j++) {
				output.append(arr[i][j]).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}
