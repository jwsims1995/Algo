package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S4_1755_숫자놀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M, N;
	static class Word implements Comparable<Word>{
		String word;
		int num;
		
		public Word(String word, int num) {
			this.word = word;
			this.num = num;
		}
		
		@Override
		public int compareTo(Word o) {
			return this.word.compareTo(o.word);
		}
	}
	static String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		List<Word> list = new ArrayList<>();
		
		for(int num = M; num<=N; num++) {
			Word word = change(num);
			list.add(word);
		}
		
		Collections.sort(list);
		int cnt = 0;
		for(Word w : list) {
			output.append(w.num).append(" ");
			cnt++;
			if(cnt%10 == 0)output.append("\n");
		}
		System.out.println(output);
	}
	private static Word change(int num) {
		if(num<10) {
			return new Word(str[num], num);
		}else {// 두자리수
			int ten = num/10;
			int one = num%10;
			String tmp = str[ten] + " " + str[one];
//			System.out.println(tmp);
			return new Word(tmp, num);
		}
	}
	static String src = "8 28";
}
