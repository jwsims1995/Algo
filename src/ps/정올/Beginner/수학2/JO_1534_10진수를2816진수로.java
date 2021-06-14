package ps.정올.Beginner.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO_1534_10진수를2816진수로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		int sum = 0;
		char[] C = input.readLine().toCharArray();
		int mul = (int) Math.pow(2, C.length-1);
		for (int c = 0; c < C.length; c++) {
			if(C[c]=='1')sum+= mul;
			mul/=2;
		}
		System.out.println(sum);
	}
}
