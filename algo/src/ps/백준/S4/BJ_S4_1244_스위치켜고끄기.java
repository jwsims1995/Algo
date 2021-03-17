package ps.백준.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @since 2021. 2. 1.
 * @author Jaewon
 * @see https://www.acmicpc.net/problem/1244
 * @mem
 * @time
 * @caution
 */

public class BJ_S4_1244_스위치켜고끄기 {
	static int S; //100 이하인 양의 정수 스위치 개수
	static boolean[] status; //켜져있으면 1, 꺼져있으면 0
	static int N; //100이하인 학생수
	static int Gender; // 성별
	static int num; // 스위치 번호
	
	static BufferedReader input;
	static StringTokenizer token;
	
	public static void main(String[] args) throws IOException {
		
		input = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(input.readLine());
		
		String line = input.readLine();
		
		status = new boolean[S];
		token = new StringTokenizer(line);
				
		for(int i=0; i<S; i++) {
			int flag = Integer.parseInt(token.nextToken());
			if(flag==1)status[i] = true;
			else status[i]= false;
		}

		N = Integer.parseInt(input.readLine());
		
		
		for(int n=0; n<N; n++) {
			sol();
		}
		printSol();
	}
	
	static void sol() throws IOException {
		String line = input.readLine();
		token = new StringTokenizer(line);
		Gender = Integer.parseInt(token.nextToken());
		if(Gender == 1) { // 남학생이 받았을 때
			num = Integer.parseInt(token.nextToken());
			int plus = num;
			while(num < S) {
				if(status[num-1]) status[num-1] = false;
				else status[num-1] = true;
				
				num+=plus;
			}
		}
		
		else { // 여학생이 받았을 때
			num = Integer.parseInt(token.nextToken());

			int l = num-2;
			int r = num;
			
			while(r < S && 0 <= l) {
				
				if(status[l] ^ status[r]) break; //다르다면 break
				else {

					status[l] = !status[l--];
					status[r] = !status[r++];
					
				}
			}
			status[num-1] = !status[num-1];
		}
	}
	
	static void printSol() {
		for(int i=0; i<S; i++) {

			if(status[i])System.out.print(1 + " ");
			else System.out.print(0 + " ");
		}
	}
}
