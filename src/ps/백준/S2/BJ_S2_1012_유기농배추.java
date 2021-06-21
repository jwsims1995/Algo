package ps.백준.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1012_유기농배추 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int x1,x2,x3,x4;
	static int y1,y2,y3,y4;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		for (int t = 0; t < 4; t++) {
			tokens =new StringTokenizer(input.readLine());
			x1 = Integer.parseInt(tokens.nextToken());
			y1 = Integer.parseInt(tokens.nextToken());
			x2 = Integer.parseInt(tokens.nextToken());
			y2 = Integer.parseInt(tokens.nextToken());
			x3 = Integer.parseInt(tokens.nextToken());
			y3 = Integer.parseInt(tokens.nextToken());
			x4 = Integer.parseInt(tokens.nextToken());			
			y4 = Integer.parseInt(tokens.nextToken());
			
			if((x1 == x4 && y2==y3) ||(x2== x3 && y2==y3) || (x1 == x4 && y1 ==y4)|| (x2 == x3 && y1==y4)) {// 점
				System.out.println("c");
			}
			else if(x2<x3 || x4<x1 || y2<y3 || y4<y1) { // 없음
				System.out.println("d");
			}
			else if((x2==x3 && y2!=y3) || (x1==x4 && y1!=y4) || (y1==y4 && x1!=x4) || (y2==y3 && x2!=x3)){// 선분
				System.out.println("b");
			}
			else System.out.println("a");
		}
	}

	static String src = "3 10 50 60 100 100 200 300\r\n" + "45 50 600 600 400 450 500 543\r\n"
			+ "11 120 120 230 50 40 60 440\r\n" + "35 56 67 90 67 80 500 600";
}
