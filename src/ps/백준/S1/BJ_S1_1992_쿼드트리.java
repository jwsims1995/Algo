package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_1992_쿼드트리 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new char[N][];
		for (int n = 0; n < N; n++) {
			map[n] = input.readLine().toCharArray();
		}
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}

		divide(0, 0, N);
		System.out.println(output);
	}



	private static void divide(int r, int c, int n) {
		//시작점 r,c
		
		//만약 모든 색이 동일하다면 return;
		if(isSame(r,c,n)) {
			output.append(map[r][c]);
			return;
		}
		// 4개로 나눈다.
		output.append("(");
		int m = n/2;
		divide(r,c,m);
		divide(r,c+m,m);
		divide(r+m,c,m);
		divide(r+m,c+m,m);
		output.append(")");
	}

	private static boolean isSame(int r, int c, int n) {
		for (int i = r+1; i < r+n; i++) {
			for (int j = c+1; j < c+n; j++) {
				if(map[r][c] != map[i][j])return false;
			}
		}
		return true;
	}



	private static String src = "8\r\n" + "11110000\r\n" + "11110000\r\n" + "00011100\r\n" + "00011100\r\n"
			+ "11110000\r\n" + "11110000\r\n" + "11110011\r\n" + "11110011";
}
