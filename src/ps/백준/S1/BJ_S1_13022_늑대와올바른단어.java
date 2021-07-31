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
	
	static char[] cycle = {'w', 'o', 'l', 'f'};
	static int[] count = new int[4];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		char[] words = input.readLine().toCharArray();
		
		System.out.println(sol(words));
		
	}
	
	private static int sol(char[] words) {
		int size = words.length;
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if(words[0] != cycle[0]) return 0;
			if(words[i] == cycle[cnt%4]) { // w->w, o->o. l->l, f->f
				count[cnt%4]++;
				continue;
			}
			
			if(words[i] == cycle[(cnt+1)%4]) { //w->o, o->l, l->f, f-> w
				cnt++;
				count[cnt%4]++;
				continue;
			}
			return 0;
				
		}
		
		System.out.println(Arrays.toString(count));
		
		int cntSize = count.length;

		for (int i = 1; i < cntSize; i++) {
			if(count[i-1] != count[i]) return 0;
		}
		return 1;
	}

	static String src = "wwoollfwolff";
}


