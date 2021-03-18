package ps.삼성.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, answer;
	static List<Point> company, home, clients;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			company = new ArrayList<>();
			home = new ArrayList<>();
			clients = new ArrayList<>();
			
			tokens = new StringTokenizer(input.readLine());
			company.add(new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken())));
			home.add(new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken())));
			
			while(tokens.countTokens() >0) {
				clients.add(new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken())));
			}
//			System.out.println("회사 = " + company);
//			System.out.println("집 = " + home);
//			System.out.println("고객 = " + clients);
			
			
			permutation(N, new Point[N], new boolean[N]);
			
			
			
			
			
			output.append(String.format("#%d %d%n", t, answer));
		}
		System.out.println(output);
	}

	
	private static void permutation(int toChoose, Point[] choosed, boolean[] visited) {
		if(toChoose == 0) {
			check(choosed);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				//choosed[choosed.length - toChoose] = clients.get(i);
				permutation(toChoose-1, choosed, visited);
				visited[i] = false;
			}
		}
	}


	private static void check(Point[] choosed) {
		for (int i = 0; i < choosed.length; i++) {
			choosed[i].col - choosed[i+1].col
		}
	}


	static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}
		
		
	}
	
	static String src = "10\r\n" + 
			"5\r\n" + 
			"0 0 100 100 70 40 30 10 10 5 90 70 50 20\r\n" + 
			"6\r\n" + 
			"88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14\r\n" + 
			"7\r\n" + 
			"22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83\r\n" + 
			"8\r\n" + 
			"30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63\r\n" + 
			"9\r\n" + 
			"3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92\r\n" + 
			"10\r\n" + 
			"39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36\r\n" + 
			"10\r\n" + 
			"26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96\r\n" + 
			"10\r\n" + 
			"46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63\r\n" + 
			"10\r\n" + 
			"94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3\r\n" + 
			"10\r\n" + 
			"32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86\r\n" + 
			"";
}
