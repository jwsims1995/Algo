package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S5_10989_수정렬하기3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder(); 
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		int[] tmp = new int[10001];				
		for (int n = 0; n < N; n++) {
			tmp[Integer.parseInt(input.readLine())]++;			
		}
		for (int t = 1; t < tmp.length; t++) {
			while(tmp[t] > 0) {
				output.append(t).append("\n");
				tmp[t]--;
			}
		}
		System.out.println(output);
	}
}
