package ps.백준.B2;

import java.io.*;
import java.util.*;

public class BJ_B2_10448_유레카이론 {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int num;
	static boolean isPos;
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int tc = Integer.parseInt(input.readLine());
		while(tc-->0) {
			num = Integer.parseInt(input.readLine());
			isPos = false;
			list = new ArrayList<>();
			int n = 1;
			while(n*(n+1)/2 < num) {
				list.add(n*(n+1)/2);
				n++;
			}
			dfs(0, 0);
			
			
			
			output.append(isPos?1:0).append("\n");
		}
		System.out.println(output);
	}

	private static void dfs(int cnt, int sum) {
		if(cnt == 3) {
			if(sum == num) isPos = true;
			return;
		}
		int size =list.size();
		for(int i =0; i<size ;i++) {
			dfs(cnt+1, sum+list.get(i));			
		}
	}

	static String src = "3\n" + 
			"10\n" + 
			"20\n" + 
			"1000";
}
