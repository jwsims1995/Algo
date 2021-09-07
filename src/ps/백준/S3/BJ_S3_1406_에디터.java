package ps.백준.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S3_1406_에디터 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		List<Character> list = new ArrayList<>();
		String line = input.readLine();
		N = line.length();
		for(int i=0; i<N; i++) {
			list.add(line.charAt(i));
		}
//		System.out.println(list);
		int M = Integer.parseInt(input.readLine());
		int idx = N;
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			char spell = tokens.nextToken().charAt(0);
			char in = ' ';
			switch(spell) {
			case 'P':
				in = tokens.nextToken().charAt(0);
				list.add(idx, in);
				idx++;
				break;
			case 'L':
				if(idx == 0)break;
				idx--;
				break;
			case 'D':
				if(idx == list.size()) break;
				idx++;
				break;
			case 'B':
				if(idx==0) break;
				list.remove(idx-1);
				idx--;
				break;
			}
//			System.out.println(idx);
//			System.out.println(list);
//			System.out.println();
		}
		int size = list.size();
		for(int i=0; i<size; i++) {
			output.append(list.get(i));
		}
		System.out.println(output);
	}
	static String src = "dmih\n" + 
			"11\n" + 
			"B\n" + 
			"B\n" + 
			"P x\n" + 
			"L\n" + 
			"B\n" + 
			"B\n" + 
			"B\n" + 
			"P y\n" + 
			"D\n" + 
			"D\n" + 
			"P z";
}
