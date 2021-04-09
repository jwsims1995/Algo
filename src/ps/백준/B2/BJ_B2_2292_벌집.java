package ps.백준.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B2_2292_벌집 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static long N;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		N = Long.parseLong(input.readLine());

			long tmp = N;
			long op = 1;
			
			if(N==1) {
				System.out.println(1);
				System.exit(0);
			}
			
			while(tmp > 0) {
				tmp -= op;
				op = ans * 6;
				ans++;
			}
			System.out.println(ans-1);
		}
	

	static String src = "13";
}
