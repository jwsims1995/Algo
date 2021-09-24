package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class BJ_S5_2609_최대공약수와최소공배수 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder(); 
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		
		output.append(gcd(a,b)).append("\n").append(lcm)
		
	}
	static String src ="24 18";
}
