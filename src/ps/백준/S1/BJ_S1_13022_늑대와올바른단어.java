package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_13022_늑대와올바른단어 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static char[] cycle = {'w','o','l','f'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
				
		System.out.println(sol()?1:0);
	}

	
	static boolean sol() {
		boolean isCorrect = true;
		char[] spell = src.toCharArray();
		int W = 0;
		int O = 0;
		int L = 0;
		int F = 0;
		int size = spell.length; //전체 길이
		for (int i = 0; i < size; i++) {
			if(i+1<size) {
				if(spell[i] == 'f' && spell[i+1] == 'w') {
					
					if(W != O || O != L  || L != F+1) {
						isCorrect = false;
						return isCorrect;
					}
						W=0;
						O=0;
						L=0;
						F=0;
					}
				
				else if(spell[i] == 'w' && spell[i+1] == 'w' || spell[i] == 'w' && spell[i+1] == 'o') {
					W++;
				}
			
				else if(spell[i] == 'o' && spell[i+1] == 'o' || spell[i] == 'o' && spell[i+1] == 'l') {
					O++;
				}
				else if(spell[i] == 'l' && spell[i+1] == 'l' || spell[i] == 'l' && spell[i+1] == 'f') {
					L++;
				}
				else if(spell[i] == 'f' && spell[i+1] == 'f') {
					F++;
				}
				else {
					isCorrect = false;
					return isCorrect;
				}
			}
		}
		if(W != O || O != L  || L != F+1) {
			isCorrect = false;
			return isCorrect;
		}
		return isCorrect;
	}
	

	static String src = "wowollff";
}


