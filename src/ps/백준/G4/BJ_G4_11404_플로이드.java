package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_11404_플로이드 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // bufferdReader로 입력받기
	static StringBuilder output = new StringBuilder(); // stringbuilder를 통해 출력시간 줄이기
	static StringTokenizer tokens; // tokensizer 를 통해 token화를 시키기 위한 준비
	static int N, M;
	static int[][] map;
	static int INF =1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src)); // String src를 이용해서 미리
		// 입력받은 입력값을 input으로 설정
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		map= new int[N+1][N+1];
		for(int i=1; i<=N;i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				map[i][j] = INF;
			}
		}
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int cost = Integer.parseInt(tokens.nextToken());
			map[start][end] = Math.min(map[start][end], cost);
		}
		

		
		for(int k=1; k<= N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] = Math.min(map[i][j],map[i][k] + map[k][j]);
				}
			}
		}
		
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				if(map[r][c] >= INF) output.append("0 ");
				else output.append(map[r][c] +" ");
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	static String src = "5\n" + 
			"14\n" + 
			"1 2 2\n" + 
			"1 3 3\n" + 
			"1 4 1\n" + 
			"1 5 10\n" + 
			"2 4 2\n" + 
			"3 4 1\n" + 
			"3 5 1\n" + 
			"4 5 3\n" + 
			"3 5 10\n" + 
			"3 1 8\n" + 
			"1 4 2\n" + 
			"5 1 7\n" + 
			"3 4 2\n" + 
			"5 2 4";
}
