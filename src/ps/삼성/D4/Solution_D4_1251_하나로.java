package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N;
	static int[] X, Y;
	static int graph[][];
	static double E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			tokens = new StringTokenizer(input.readLine());
			for (int n = 0; n < N; n++) {
				X[n] = Integer.parseInt(tokens.nextToken());
			}
			tokens = new StringTokenizer(input.readLine());
			for (int n = 0; n < N; n++) {
				Y[n] = Integer.parseInt(tokens.nextToken());
			}
			E = Double.parseDouble(input.readLine());
			//입력완료
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				int x1 = X[i];
				int y1 = Y[i];
				for (int j = i+1; j < N; j++) {
					int x2 = X[j];
					int y2 = Y[j];
					
					graph[i][j] = graph[j][i] = (int) (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
				}
			}
			double cost = Prim(0) * E;
		}
	}
	static double Prim(int start) {
		PriorityQueue<Edge>
		return 0;
	}
	
	static class Edge{
		int cost;
		int 
	}
}
