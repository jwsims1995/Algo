package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1633_최고의팀만들기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		int cnt =0;
		List<Integer> white = new LinkedList<>();
		List<Integer> black = new LinkedList<>();
		
		while(true) {
			
			String line = input.readLine();
			if(line.equals(null))break;
			System.out.println(line);
			
			tokens = new StringTokenizer(line);
			System.out.println(cnt++);
			int w = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			white.add(w);
			black.add(b);
		}
		Collections.sort(white, Comparator.reverseOrder());
		Collections.sort(black, Comparator.reverseOrder());
		System.out.println(white);
		System.out.println(black);
	}

	static String src = "87 84\n" + 
			"66 78\n" + 
			"86 94\n" + 
			"93 87\n" + 
			"72 100\n" + 
			"78 63\n" + 
			"60 91\n" + 
			"77 64\n" + 
			"77 91\n" + 
			"87 73\n" + 
			"69 62\n" + 
			"80 68\n" + 
			"81 83\n" + 
			"74 63\n" + 
			"86 68\n" + 
			"53 80\n" + 
			"59 73\n" + 
			"68 70\n" + 
			"57 94\n" + 
			"93 62\n" + 
			"74 80\n" + 
			"70 72\n" + 
			"88 85\n" + 
			"75 99\n" + 
			"71 66\n" + 
			"77 64\n" + 
			"81 92\n" + 
			"74 57\n" + 
			"71 63\n" + 
			"82 97\n" + 
			"76 56";
}
