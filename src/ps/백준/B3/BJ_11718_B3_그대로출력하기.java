package ps.백준.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_11718_B3_그대로출력하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		
		String str = "";
		while((str = input.readLine()) != null) {
			System.out.println(str);
		}
		
	}
	static String src = "Hello\r\n" + 
			"Baekjoon\r\n" + 
			"Online Judge";
}
