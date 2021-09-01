package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_21278_호석이두마리치킨 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int S, E;
	static int[][] distance;
	static int[] place;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		distance = new int[N+1][N+1];
		place = new int[2];
		//INF로 초기화
		 
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) continue;
				distance[i][j] = N;
			}
		}
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			distance[start][end] = distance[end][start] = 1;
		}
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					distance[i][j] = Math.min(distance[i][j] , distance[i][k] + distance[k][j]);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(distance[i][j] >= N) distance[i][j] = 0;
			}
		}
//		for(int i=1; i<=N;i++) {
//			for(int j=1; j<=N; j++) {
//				System.out.print(distance[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		////////////////
		
		int sum = Integer.MAX_VALUE;
		int S = Integer.MAX_VALUE;
		int E = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				int dist =0;
				for(int k=1; k<=N; k++) {
					dist+=Math.min(distance[i][k],distance[k][j]);
				}
				if(sum > dist) {
					sum = dist;
					S = i;
					E = j;
				}
			}
		}
		
		System.out.print(S + " " + E + " " + sum*2);
	}

	static String src = "5 4\n" + 
			"1 3\n" + 
			"4 2\n" + 
			"2 5\n" + 
			"3 2";
}
