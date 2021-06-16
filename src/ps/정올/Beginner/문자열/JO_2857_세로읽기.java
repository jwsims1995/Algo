package ps.정올.Beginner.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2857_세로읽기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[][] arr = new char[5][15];
	static char[][] map = new char[5][15];
	public static void main(String[] args) throws IOException {

		for (int r = 0; r < 5; r++) {
			map[r] = input.readLine().toCharArray();
			Arrays.fill(arr[r], ' ');
		}
		
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				arr[r][c] = map[r][c];
			}
		}
		for (int c = 0; c < 15; c++) {
			for (int r = 0; r < 5; r++) {
				if(arr[r][c]==' ')continue;
				output.append(arr[r][c]);
			}
		}
		System.out.println(output);
	}
}
