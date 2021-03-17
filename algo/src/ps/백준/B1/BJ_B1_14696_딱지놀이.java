package ps.백준.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_14696_딱지놀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N;
	static int[] A;
	static int[] B;
	static char answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		for (int n = 0; n < N; n++) {
			A = new int[5];
			B = new int[5];
			tokens = new StringTokenizer(input.readLine());
			int numA = Integer.parseInt(tokens.nextToken());
			for (int i = 1; i <= numA; i++) {
				A[Integer.parseInt(tokens.nextToken())]++;
			}
			tokens = new StringTokenizer(input.readLine());
			int numB = Integer.parseInt(tokens.nextToken());
			for (int i = 1; i <= numB; i++) {
				B[Integer.parseInt(tokens.nextToken())]++;
			}
			//입력완료
			for (int i = 4; i >=0 ; i--) {
				if(A[i] > B[i]) {
					answer = 'A';
					break;
				}
				else if(A[i] < B[i]) {
					answer = 'B';
					break;
				}
				else answer = 'D';
			}
			System.out.println(answer);
		}
	}
	static String src = "5\r\n" + 
			"1 4\r\n" + 
			"4 3 3 2 1\r\n" + 
			"5 2 4 3 2 1\r\n" + 
			"4 4 3 3 1\r\n" + 
			"4 3 2 1 1\r\n" + 
			"4 2 3 2 1\r\n" + 
			"4 4 3 2 1\r\n" + 
			"3 4 3 2\r\n" + 
			"5 4 4 2 3 1\r\n" + 
			"5 4 2 4 1 3";
}
