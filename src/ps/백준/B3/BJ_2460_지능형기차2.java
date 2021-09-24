package ps.백준.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BJ_2460_지능형기차2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input  = new BufferedReader(new StringReader(src));
		int num=0;
		int max =0;
		for(int i=0; i<10; i++) {
			tokens = new StringTokenizer(input.readLine());
			int out = Integer.parseInt(tokens.nextToken());
			int in = Integer.parseInt(tokens.nextToken());
			
			num-=out;
			num+=in;
			max= Math.max(num, max);
		}
		System.out.println(max);

	}
	static String src = "0 32\n" + 
			"3 13\n" + 
			"28 25\n" + 
			"17 5\n" + 
			"21 20\n" + 
			"11 0\n" + 
			"12 12\n" + 
			"4 2\n" + 
			"0 8\n" + 
			"21 0";
}
