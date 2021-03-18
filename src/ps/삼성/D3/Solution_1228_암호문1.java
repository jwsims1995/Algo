package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, space;

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int t = 1; t <= 10; t++) {
			LinkedList<Integer> LinkedList = new LinkedList<>();
			
			space = Integer.parseInt(input.readLine());
			tokens = new StringTokenizer(input.readLine());
			for (int i = 0; i < space; i++) {
				LinkedList.add(Integer.parseInt(tokens.nextToken()));
			}
			
			N = Integer.parseInt(input.readLine());
			String[] line = input.readLine().split("I");

			for (int n = 1; n < N+1; n++) {
				tokens = new StringTokenizer(line[n]);
				int pos = Integer.parseInt(tokens.nextToken());
				int val = Integer.parseInt(tokens.nextToken());
				for (int i = 0; i < val; i++) {
					LinkedList.add(pos+i, Integer.parseInt(tokens.nextToken()));
				}
			}
			output.append("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				output.append(LinkedList.get(i) + " ");
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}

