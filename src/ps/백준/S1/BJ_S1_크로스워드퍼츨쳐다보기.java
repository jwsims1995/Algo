package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_크로스워드퍼츨쳐다보기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C;
	static char[][] map;
	static PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}

	});
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map= new char[R][C];
		//map 입력
		for(int r=0; r<R;r++) {
			map[r] = input.readLine().toCharArray();
		}
//		for(char[] row: map) {
//			System.out.println(row);
//		}//입력확인
		//왼쪽 -> 오른쪽
		for(int r=0;r<R;r++){
			String line = "";
			for(int c=0;c<C;c++) {
				line += map[r][c];
			}
			String[] words = line.split("#");
			for(int w=0; w<words.length; w++) {
				if(words[w].length() >= 2) {
					pq.add(words[w]);
				}
			}
		}
		//위-> 아래
		for(int c=0;c<C;c++){
			String line = "";
			for(int r=0;r<R;r++) {
				line += map[r][c];
			}
			String[] words = line.split("#");
			for(int w=0; w<words.length; w++) {
				if(words[w].length() >= 2) {
					pq.add(words[w]);

				}
			}
		}
		System.out.println(pq.peek());
	}
	
	static String src= "4 5\r\n" + 
			"adaca\r\n" + 
			"da##b\r\n" + 
			"abb#b\r\n" + 
			"abbac";
}
