package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, ans;
	static int[] weight;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//
		
		
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			tokens = new StringTokenizer(input.readLine());
			weight = new int[N];
			for (int n = 0; n < N; n++) {
				weight[n] = Integer.parseInt(tokens.nextToken());
			}
			//System.out.println(Arrays.toString(weight));
			// 입력 완료
			
			ans = 0;
			//순열돌리기...
			
			
			// 출력 완료
			output.append(String.format("#%d %d%n", t, ans));
		}
		System.out.println(output);
	}
	
	static void permutation(int toChoose, boolean[] visited, int left, int right) {
		if(toChoose==0) {
			//정답처리
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				// i를 선택한 후 --> 
				permutation(toChoose-1, visited, left, right);
				visited[i] = false;
			}
		}
	}


	static String src = "3\r\n" + 
			"3\r\n" + 
			"1 2 4\r\n" + 
			"3\r\n" + 
			"1 2 3\r\n" + 
			"9\r\n" + 
			"1 2 3 5 6 4 7 8 9";
}
