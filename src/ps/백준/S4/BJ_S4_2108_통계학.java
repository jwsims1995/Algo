package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S4_2108_통계학 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine()); // 홀수 N
		double d  = (double)N;
		int[] num = new int[N];
		int ans1 = 0;
		int ans2 =0;
		int ans3= 0;
		int ans4 =0;
		for(int n=0; n<N; n++) {
			num[n]= Integer.parseInt(input.readLine());
		}
//		System.out.println(Arrays.toString(num));
		// #1
		int sum =0;
		for(int n=0; n<N; n++) {
			sum+= num[n];
		}
		
		double a = Math.round(sum/d); // 산술평균
		ans1 = (int)a;
		
		Arrays.sort(num);
		ans2 = num[N/2]; // 중앙값
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int n=0; n<N; n++) {
			
			if(map.containsKey(num[n])) {
				map.put(num[n], map.get(num[n])+1);
			}
			else{
				map.put(num[n], 1);
			}
		}
//		System.out.println(map);
		int max = 0;
		int cnt = 0;
		for(Integer i : map.keySet()) {
			if(cnt < map.get(i)) {
				cnt = map.get(i);
				max = i;
			}
		}
		List<Integer> list = new ArrayList<>();
		for(Integer i : map.keySet()) {
			if(cnt == map.get(i)) {
				list.add(i);
			}
		}
		if(list.size() > 1) {
			Collections.sort(list);
			ans3= list.get(1);
		}else {
			ans3 = list.get(0);
		}
		
		Arrays.sort(num);
		ans4 = num[N-1]-num[0];
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		System.out.println(ans4);
	}
	
	static String src ="5\n" + 
			"-1\n" + 
			"-2\n" + 
			"-3\n" + 
			"-1\n" + 
			"-2";
}
