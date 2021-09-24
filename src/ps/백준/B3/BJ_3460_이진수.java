package ps.백준.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BJ_3460_이진수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input  = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for(int t=0 ; t<T; t++) {
			int N = Integer.parseInt(input.readLine());
			int cnt =0;
			while(N>0) {
				if(N%2==1)output.append(cnt).append(" ");
				N/=2;
				cnt++;
			}
			output.append("\n");
		}
		System.out.println(output);

	}
	static String src = "1\n" + 
			"13";
}
