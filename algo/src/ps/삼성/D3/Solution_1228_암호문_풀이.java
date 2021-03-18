package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N; //암호문 개수
	static int C; //명령문 개수
	static List<String> cryptogram;

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(input.readLine());
			// 중간에 데이터가 삽입된다.
			cryptogram = new LinkedList<>();
			tokens = new StringTokenizer(input.readLine(), " "); // I 또는 공백으로 나눠!
			//input.readLine().split("I "); // I공백으로 구분
//			input.readLine().split("[I ]"); // I 또는 공백으로 구분
			//split 은 정규표현식 기준으로 나눈다. regex... 이걸 잘 알면 그때 사용하는게 유리함
			
			while(tokens.hasMoreTokens()) {
				cryptogram.add(tokens.nextToken());
			}
			C = Integer.parseInt(input.readLine());
			
			tokens = new StringTokenizer(input.readLine(), "I ");
			while(tokens.hasMoreTokens()) {
				int idx = Integer.parseInt(tokens.nextToken());
				int len = Integer.parseInt(tokens.nextToken());
				for (int i = 0; i < len; i++) {
					cryptogram.add(idx++, tokens.nextToken());
				}
			}
			output.append(String.format("#%d ", t));
			for (int i = 0; i < 10; i++) {
				output.append(cryptogram.get(i)).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}

