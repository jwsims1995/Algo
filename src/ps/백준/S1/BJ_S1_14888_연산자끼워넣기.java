package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_14888_연산자끼워넣기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] A;
	static int[] op = new int[4]; // + - * /
	static List<Character> list = new ArrayList<Character>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		A = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n <N; n++) {
			A[n] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] += Integer.parseInt(tokens.nextToken());
		}
		//입력완료
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(op));
		//입력확인
		permutation(N-1, new boolean[4])
		
	}
	static String src = "3\n" + 
			"3 4 5\n" + 
			"1 0 1 0";
}