package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static int[] kyCard = new int[9];
	static int[] iyCard = new int[9];
	static int kyWin, iyWin;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {			
			tokens = new StringTokenizer(input.readLine());
			ArrayList<Integer> arrs = new ArrayList<>();
			
			for (int n = 0; n < kyCard.length; n++) {
				kyCard[n] = Integer.parseInt(tokens.nextToken());
				arrs.add(kyCard[n]);
			}
			for (int i = 1, cnt = 0; i <= kyCard.length * 2; i++) {
				if(!arrs.contains(i))iyCard[cnt++] = i;
			}
//			System.out.println(Arrays.toString(kyCard));//규영이 입력확인
//			System.out.println(Arrays.toString(iyCard));//규영이 입력확인

			kyWin = 0;
			iyWin = 0;
			
			permutation(iyCard.length, new int[iyCard.length], new boolean[iyCard.length]);
			
			
			
			
			////////
			output.append(String.format("#%d %d %d%n", t, kyWin, iyWin));
		}
		System.out.println(output);
	}
	
	static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if(toChoose == 0) {
			//System.out.println(Arrays.toString(choosed));
			check(choosed);
			return;
		}
		for (int i = 0; i < iyCard.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[choosed.length - toChoose] = iyCard[i]; 
				permutation(toChoose-1, choosed, visited);
				visited[i] = false;				
			}
		}
	}
	
	static void check(int[] choosed) {
		int kyScore = 0, iyScore = 0;
		for (int i = 0; i < choosed.length; i++) {
			// 카드는 같을 수 없다.
			if (kyCard[i] > choosed[i]) {
				kyScore += kyCard[i] + choosed[i];
			} else {
				iyScore += kyCard[i] + choosed[i];
			}
		}
		// 점수는 같을 수 있으므로 주의~~
		if (kyScore > iyScore) {
			kyWin++;
		} else if (kyScore < iyScore) {
			iyWin++;
		}
	}
}
