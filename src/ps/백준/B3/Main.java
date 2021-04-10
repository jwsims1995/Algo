package ps.백준.B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		for (int n = 1; n <= N; n++) {
			for (int i = N-n+1; i < N; i++) {
				System.out.printf(" ");
			}
			
			
			for (int i = 1; i <= N-n+1; i++) {				
				System.out.printf("*");
			}
			System.out.println();
		}
	}

}
