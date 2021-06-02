package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S5_11651_좌표정렬하기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][2];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			map[n][0] = Integer.parseInt(tokens.nextToken());
			map[n][1] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(map, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(map[i][0] + " " + map[i][1]);
		}
	}

	static String src = "5\r\n" + 
			"0 4\r\n" + 
			"1 2\r\n" + 
			"1 -1\r\n" + 
			"2 2\r\n" + 
			"3 3";
}
