package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B2_13300_방배정 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine()," ");
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		int [][] infos = new int[2][7]; // 성별, 학년
		
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int gender = Integer.parseInt(tokens.nextToken());
			int year = Integer.parseInt(tokens.nextToken());
			//System.out.println(gender+" : " + year);
			infos[gender][year]++;
		}
		// 필요한 방 계산하기
		int rooms = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				if(infos[i][j] == 0) continue;
				rooms+= infos[i][j]/K;
				if(infos[i][j]%K > 0) rooms++;
			}
		}
		System.out.println(rooms);
	}
	
	private static String src = "3 3\r\n" + 
			"0 3\r\n" + 
			"1 5\r\n" + 
			"0 6";
}
