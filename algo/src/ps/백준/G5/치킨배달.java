package ps.백준.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M;
	static int answer;
	static int[][] map;
	static List<Point> homes, chickens;
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		homes = new ArrayList<Point>();
		chickens = new ArrayList<Point>();
		answer = Integer.MAX_VALUE;
		for (int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 1; c <= N; c++) {
				String temp = tokens.nextToken();
				if(temp.equals("1")) {
					homes.add(new Point(r,c));
				}
				else if(temp.equals("2")){
					chickens.add(new Point(r,c));
				}
			}
		}
		//System.out.println("homes= " + homes);
		//System.out.println("chickens= " +chickens);
		
		combi(M, new Point[M], 0);
		System.out.println(answer);
	}
	static void combi(int toChoose, Point[] choosed, int startIdx) {
		if(toChoose == 0) {
			choice(choosed);
			//System.out.println(Arrays.toString(choosed));
			return;
		}
		for (int i = startIdx; i < chickens.size(); i++) {
			choosed[choosed.length - toChoose] = chickens.get(i);
			combi(toChoose-1, choosed, i+1);
		}
	}
	static void choice(Point[] tmp) {
		int cityChickenDist = 0;
		for (Point home : homes) {
			int minDist = Integer.MAX_VALUE;
			for (Point chicken : tmp) {
				minDist = Math.min(minDist, Math.abs(home.row - chicken.row)+ Math.abs(home.col - chicken.col));
			}
			cityChickenDist += minDist;
		}
		answer = Math.min(answer, cityChickenDist);
	}
	static class Point{
		int row;
		int col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "[row=" + row + ", col=" + col + "]";
		}
		
	}
	private static String src = "5 3\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 2 0 1\r\n" + 
			"0 1 2 0 0\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 0 0 2";
}
