package ps.정올.Beginner.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JO_2514_문자열찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		int koi = 0;
		int ioi =0;
		char[] in = input.readLine().toCharArray();
		for (int i = 0; i < in.length-2; i++) {
			output = new StringBuilder();
			output.append(in[i]).append(in[i+1]).append(in[i+2]);
			if(output.toString().equals("KOI"))koi++;
			else if(output.toString().equals("IOI"))ioi++;
		}
		System.out.println(koi);
		System.out.println(ioi);
	}
}
