package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_2941_크로아티아알파벳 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder(); 
	static StringTokenizer tokens;
	static int N;
	static String[] str = {"c=","c-","dz=","d-","lj","nj","s=","z="};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String line = input.readLine();
		for(String s : str) {
			if(line.contains(s)) {
				line = line.replaceAll(s, " ");
			}
		}
		
		System.out.println(line.length());
	}
	static String src ="nljj";
}
