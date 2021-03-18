package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 2.
 * @author Jaewon
 * @see https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
 * @mem
 * @time
 * @caution
 */

public class Solution_1208_Flatten {
//최고점과 최저점의 차이를 반환
	static int N;
	static int MAX_SIZE = 100;
	static int T_SIZE = 10;
	static int[] height;
	static BufferedReader input;
	static StringTokenizer tokens;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<T_SIZE; t++) { //10번 테스트 케이스
			N = Integer.parseInt(input.readLine()); // 덤프 횟수
			String line = input.readLine();
			tokens = new StringTokenizer(line);
			height = new int[MAX_SIZE];
			for(int i=0; i<MAX_SIZE; i++) {
				height[i] = Integer.parseInt(tokens.nextToken());
			}
			
			
			for(int n=0; n<N; n++) {
				height[max(height)]--;
				height[min(height)]++;
			}
			
			answer = height[max(height)] - height[min(height)];
			System.out.println("#"+(t+1)+" "+answer);
			//max -  min
			
			//////////
		}
	}
	
	public static int min(int[] arr) {
		int min=arr[0];
		int index=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	public static int max(int[] arr) {
		int max=arr[0];
		int index=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				index=i;
			}
		}
		return index;
	}
}
