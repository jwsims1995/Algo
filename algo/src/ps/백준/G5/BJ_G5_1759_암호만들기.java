package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 16.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class BJ_G5_1759_암호만들기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int L, N;
	static String[] spell;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		L = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		spell = input.readLine().split(" ");
		Arrays.sort(spell);

		// System.out.println("spell : " + Arrays.toString(spell));
		combi(L, new String[L], 0); 
		System.out.println(output);
	}

	private static void combi(int toChoose, String[] choosed, int idx) {
		if (toChoose == 0) {
			if(check(choosed)) {
				for (int i = 0; i < choosed.length; i++) {
					output.append(choosed[i]);					
				}
				output.append("\n");
			}
			return;
		}
		for (int i = idx; i < spell.length; i++) {
			choosed[choosed.length - toChoose] = spell[i];
			combi(toChoose - 1, choosed, i + 1);
		}
	}
	
	private static boolean check(String[] choosed) { // 최소 한개 모음, 두개의 자음
		int conconant = 0;
		int vowel = 0;
		for(String c : choosed)
		if(c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")){
			conconant++;
		}else {
			vowel++;
		}
		return conconant>=1 && vowel >= 2;
	}

	static String src = "4 6\r\n" + "a t c i s w";
}
