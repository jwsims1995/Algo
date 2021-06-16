package ps.정올.Beginner.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1880_암호풀기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] alp = new int [26];
	static char[] key;
	static char[] msg;
	//65 97
	public static void main(String[] args) throws IOException {
		key = input.readLine().toCharArray();
		msg = input.readLine().toCharArray();
		
		for (int m = 0; m < msg.length; m++) {
			if('A' <=msg[m] && msg[m] <= 'Z') { //대문자
				output.append((char)(key[msg[m]-65]-32));
			}else if('a' <=msg[m] && msg[m] <= 'z'){
				output.append(key[msg[m]-97]);
			}else {//빈칸
				output.append(msg[m]);
			}
		}
		System.out.println(output);
	}
}
