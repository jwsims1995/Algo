package ps.백준.S3;
/**
 * @since 2021. 3. 17.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S3_14889_스타트와링크 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, start, link;
	static int min = Integer.MAX_VALUE;
	static int[][] stat;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		stat = new int[N][N];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < N; c++) {
				stat[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}//입력완료
		combi(N/2 , new int[N/2], 0);
		System.out.println(min);

	}
	private static void combi(int toChoose, int[] choosed, int idx) {
		if(toChoose == 0) {
			//unchoosed구하기
			visit = new boolean[N];
			for (int i = 0; i < choosed.length; i++) {
				visit[choosed[i]]= true;
			}
			List<Integer> unchoosed=  new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				if(!visit[i])unchoosed.add(i);
			}
//			System.out.println(unchoosed);
			
			//choosed 출력
//			System.out.println(Arrays.toString(choosed));
			
			differ(choosed, unchoosed);
			
			

			return;
		}
		for (int i = idx; i < N; i++) {
			choosed[choosed.length-toChoose] = i;
			combi(toChoose-1, choosed, i+1);
		}
	}
	private static void differ(int[] choosed, List<Integer> unchoosed) {
		start = 0;
		link = 0;
		for (int i = 0; i < N/2-1; i++) {
			for (int j = i+1; j < N/2; j++) {
				start += stat[choosed[i]][choosed[j]] + stat[choosed[j]][choosed[i]];
			}
		}
		
		for (int i = 0; i < N/2-1; i++) {
			for (int j = i+1; j < N/2; j++) {
				link += stat[unchoosed.get(i)][unchoosed.get(j)] + stat[unchoosed.get(j)][unchoosed.get(i)];
			}
		}
//		System.out.println("start : " + start);
//		System.out.println("link : " + link);
		
		min = Math.min(min, Math.abs(start-link));
	}
	static String src = "8\r\n" + 
			"0 5 4 5 4 5 4 5\r\n" + 
			"4 0 5 1 2 3 4 5\r\n" + 
			"9 8 0 1 2 3 1 2\r\n" + 
			"9 9 9 0 9 9 9 9\r\n" + 
			"1 1 1 1 0 1 1 1\r\n" + 
			"8 7 6 5 4 0 3 2\r\n" + 
			"9 1 9 1 9 1 0 9\r\n" + 
			"6 5 4 3 2 1 9 0";
}
