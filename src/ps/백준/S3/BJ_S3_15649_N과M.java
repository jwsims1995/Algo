package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_15649_N과M {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N ,M ;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); 
		M = Integer.parseInt(tokens.nextToken());
		num  = new int[N];
		for(int n=0; n<N; n++) {
			num[n] = n+1;
		}
		combi(M, new int[M], 0);
//		perm(M, new int[M], new boolean[N]);
		System.out.println(output);
	}
	
	static void perm(int toChoose, int[] choosed, boolean[] visited) {
		if(toChoose==0) {
			for(int i=0; i<M; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[M-toChoose] = num[i];
				perm(toChoose-1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	
	static void combi(int toChoose, int[] choosed, int idx) {
		if(toChoose == 0) {
			for(int i=0; i<M;i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		for(int i=idx; i<N; i++) {
			choosed[choosed.length-toChoose]= num[i];
			combi(toChoose-1, choosed, i);
		}
	}
	static String src = "4 2";
}
