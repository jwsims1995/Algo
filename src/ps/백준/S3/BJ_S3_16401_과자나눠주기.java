package ps.백준.S3;

import java.io.*;
import java.util.*;

public class BJ_S3_16401_과자나눠주기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M, N;
	static int ans;
	static List<Integer> snack = new ArrayList<>();;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		for(int n=0;n<N;n++) {
			snack.add(Integer.parseInt(tokens.nextToken()));
		}
		Collections.sort(snack, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		if(M<=N) {
			ans = snack.get(N-M);
		}
		else {
			int divider = (M-1)/N + 1; // 2
			int min = snack.get(0)/(divider-1); // 10
			int idx = M%N==0?0:N - (M % N); // 2
			int tmp = snack.get(idx)/divider; // 15/2 = 7\
			
			ans = min>=tmp?tmp:min;
		}
		System.out.println(ans);
	}
	static String src = "11 3\n" + 
			"10 10 15";
}
