package ps.백준.B1;

import java.io.*;
import java.util.*;

public class BJ_B1_1032_명령프롬프트 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		
		if(N == 1) {
			System.out.println(input.readLine());
			System.exit(0);
		}
		char[][] name = new char[N][];
		for (int n = 0; n < N; n++) {
			name[n] = input.readLine().toCharArray();
		}
//		for (char[] row : name) {
//			System.out.println(Arrays.toString(row));
//		} // 확인

		int size = name[0].length;
		for(int s=0; s<size; s++) {
			boolean isSame = true;
			for(int n=1; n<N; n++) {
				if(name[n-1][s] != name[n][s]) isSame = false;
			}
			output.append(isSame?name[0][s]:"?");
		}
		System.out.println(output);
	}

	private static String src = "2\n" + 
			"config.sys\n" + 
			"config.inf\n" ;
}
