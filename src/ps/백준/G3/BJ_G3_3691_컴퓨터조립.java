package ps.백준.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_3691_컴퓨터조립 {
	static class Info implements Comparable<Info>{
		String type,name;
		int price, quality;
		public Info(String type, String name, int price, int quality) {
			this.type =type;
			this.name =name;
			this.price =price;
			this.quality =quality;
		}
		@Override
		public int compareTo(Info o) {
			if(this.name.equals(o.name))return o.quality - this.quality;
			return this.type.compareTo(o.type);
		}
		@Override
		public String toString() {
			return this.type + " " +this.name + " " +this.price + " " +this.quality + " "; 
		}
	}
	static class Processor {
		String name;
		int price, quality;
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, B;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			Info[] infos = new Info[N];
			for(int n=0; n<N; n++) {
				tokens = new StringTokenizer(input.readLine());
				String type = tokens.nextToken();
				String name = tokens.nextToken();
				int price = Integer.parseInt(tokens.nextToken()); 
				int quality = Integer.parseInt(tokens.nextToken());
				infos[n] = new Info(type, name, price, quality);
			}
			Arrays.sort(infos);
			System.out.println(Arrays.toString(infos));
			////////입력
			
			
			
			
		}		
	}

	static String src = "1\n" + 
			"18 800\n" + 
			"processor 3500_MHz 66 5\n" + 
			"processor 4200_MHz 103 7\n" + 
			"processor 5000_MHz 156 9\n" + 
			"processor 6000_MHz 219 12\n" + 
			"memory 1_GB 35 3\n" + 
			"memory 2_GB 88 6\n" + 
			"memory 4_GB 170 12\n" + 
			"mainbord all_onboard 52 10\n" + 
			"harddisk 250_GB 54 10\n" + 
			"harddisk 500_FB 99 12\n" + 
			"casing midi 36 10\n" + 
			"monitor 17_inch 157 5\n" + 
			"monitor 19_inch 175 7\n" + 
			"monitor 20_inch 210 9\n" + 
			"monitor 22_inch 293 12\n" + 
			"mouse cordless_optical 18 12\n" + 
			"mouse microsoft 30 9\n" + 
			"keyboard office 4 10";
}
