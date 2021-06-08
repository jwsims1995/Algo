package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_14888_연산자끼워넣기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] A;
	static int[] op = new int[4]; // + - * /
	static List<Character> list = new ArrayList<Character>();
	public static void main(String[] args) throws NumberFormatException, IOException {
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
		for (int i = 0; i < 4; i++) {
			for (int o = 0; o < op[i]; o++) {
				if(i == 0) list.add(('+')