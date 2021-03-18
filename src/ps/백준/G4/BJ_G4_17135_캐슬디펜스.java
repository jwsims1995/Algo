package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_17135_캐슬디펜스 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M, D;
	static List<Archer> map;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		map = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
			}
		}
	}
	class Archer{
		int row;
		int col;
		
		public Archer(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		@Override
		public String toString() {
			return "Archer [row=" + row + ", col=" + col + "]";
		}
	}
	private static String src = "5 5 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 1 1 1 1";
}
