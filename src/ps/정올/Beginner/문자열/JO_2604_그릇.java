package ps.정올.Beginner.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2604_그릇 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		int height = 10; //초기값
		char[] in = input.readLine().toCharArray();
		
		for (int h = 1; h < in.length; h++) {
			if(in[h-1] == in[h])height+=5;
			else height+=10;
			
		}
		System.out.println(height);
	}
}
