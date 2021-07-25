package ps.백준.B1;
/**
 * @since 2021. 3. 24.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_1259_팰린드롬수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		
		while(true)
		{
			String line = input.readLine();
			if(line.equals("0"))break;
			
			char[] num = line.toCharArray();
			int size = num.length;
			char[] tmp = new char[size];
			
			for (int i = 0; i < size; i++) {
				tmp[i]= num[size-i-1];
			}
			
			boolean isPal = true;
			for (int i = 0; i < size; i++) {
				if(tmp[i] != num[i]) {
					isPal = false;
					break;
				}
			}
			
			System.out.println(isPal?"yes":"no");
		}
	}

	static String src = "121\n" + 
			"1231\n" + 
			"12421\n" + 
			"0";
}
