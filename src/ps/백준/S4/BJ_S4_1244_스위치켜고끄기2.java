package ps.백준.S4;

import java.io.*;
import java.util.*;

public class BJ_S4_1244_스위치켜고끄기2 {
	static BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output =new StringBuilder();
	static int N, S;
	static int[] button;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		button = new int[N+1];
		tokens =new StringTokenizer(input.readLine());
		for (int n = 1; n <= N; n++) {
			button[n] = Integer.parseInt(tokens.nextToken());
		}
		S = Integer.parseInt(input.readLine());
		for (int s = 0; s < S; s++) {
			tokens =new StringTokenizer(input.readLine());
			int sex = Integer.parseInt(tokens.nextToken());
			int num = Integer.parseInt(tokens.nextToken());
			
			// 남 : num의 배수면 상태바꿈
			// 여 : num 중심 좌우가 대칭인 최대구간을 모두 바꿈
			if(sex == 1) { // 남
				for (int i = num; i <= N; i+=num) {
					change(i);
				}
			}else { //여
				int idx = 0;
				while(true) {
					int left = num-idx;
					int right =num+idx;
//					System.out.println("left : " + left);
//					System.out.println("right : " + right);
					if(isIn(left, right) && button[left]==button[right]) {
						if(idx == 0) {
							change(num);
						}else {
							change(left);
							change(right);
						}
//						System.out.println(Arrays.toString(button));
					}
					else break;
					idx++;
				}
			}
		}
		for (int n = 1; n <= N; n++) {
			output.append(button[n]).append(" ");
			if(n%20 == 0)output.append("\n");
		}
		System.out.println(output);
	}
	private static boolean isIn(int left, int right) {
		return left>=1 && left<=N && right>=1 && right<=N  ;
	}
	static void change(int idx) {
		if(button[idx] == 0) button[idx] =1;
		else button[idx] = 0;
	}
	static String src = "8\n" + 
			"0 1 0 1 0 0 0 1\n" + 
			"2\n" + 
			"1 3\n" + 
			"2 3";
}