package ps.정올.Beginner.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO_3106_진법변환 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output;
	static StringTokenizer tokens;
	static int A, N;
	static char[] B;
	public static void main(String[] args) throws IOException {
		for (int t = 0; t < 100; t++) {
			output = new StringBuilder();
			tokens= new StringTokenizer(input.readLine());
			String check = tokens.nextToken();
			if(check.equals("0"))System.exit(0);
			A = Integer.parseInt(check);
			B = tokens.nextToken().toCharArray();
			N = Integer.parseInt(tokens.nextToken());

			if(B[0] == '0') {
				System.out.println(0);
				continue;
			}
			long mul =  1;
			long sum  =0;
			Stack<Character> stack = new Stack<>();
			for (int b = 0; b < B.length; b++) {
				stack.add(B[b]);
			}
			while(!stack.isEmpty()) {
				char tmp = stack.pop();
				if(A>10 && tmp-'A'>=0) {
					sum += (tmp-'A' + 10) * mul;
					mul*=A;
				}
				else {
				sum += (tmp-'0') * mul;
				mul*=A;
				}
			}
//			System.out.println("sum : "+sum);
			
			Stack<Long> stackInt = new Stack<>();
			while(sum>0) {
				stackInt.add((sum%N));
				sum/=N;
			}
			long tmp = 0;
			while(!stackInt.isEmpty()) {
				tmp = stackInt.pop();
//				System.out.println("tmp : "+tmp);
				if(tmp >= 10) output.append((char)('A'+tmp-10));
				else
					output.append(tmp);
			}
			System.out.println(output);
		}
	}
}
