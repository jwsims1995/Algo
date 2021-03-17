package ps.삼성.D4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class 쇠막대기자르기 {
	static int T, range, N, M, cnt;
	static int ans;
	static char[] arr;
	//static int[] stick;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("resim/쇠막대기자르기.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			arr = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i]=str.charAt(i);
			}
			
			// 현재 이어지고있는 쇠막대기 숫자 
			int cnt=0;
			// 끝난 막대기 숫자
			int total = 0;
			for (int i = 0; i < arr.length; i++) {
				// 쇠막대기 시작
				if(arr[i]=='('&&i+1<arr.length&&arr[i+1]!=')') {
					cnt++;
				}
				// 쇠막대기 끝
				if(arr[i]==')'&&arr[i-1]!='(') {
					cnt--;
					total++;
				}
				// 레이저이면
				if(arr[i]==')'&&arr[i-1]=='(') {
					total += cnt;
				}
			}
			
			System.out.println("#"+tc+" "+total);
		}
		
	}
}
