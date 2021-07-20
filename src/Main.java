import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, d, K ,c;
	static int[] dishArr;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); //테이블 접시의 개
		d = Integer.parseInt(tokens.nextToken()); // 초밥의 종류
		K = Integer.parseInt(tokens.nextToken()); // 연속해서 먹을 개
		c = Integer.parseInt(tokens.nextToken()); // 쿠폰 번호
		
		dishArr = new int[N];
		for (int n = 0; n < N; n++) {
			dishArr[n] = Integer.parseInt(input.readLine());
		}
		System.out.println(solve());
		
		int n =10;
		String a = Integer.toBinaryString(n);
		System.out.println(a);
		
		String src  = "\"";
		System.out.println(src);
	     
	}
	
	static int solve() {
		// 어떤 초밥을 몇개 먹었는지 관리할 배열
		int[] check = new int[d+1];
		check[c] = 1;
		int cnt = 1; // 초밥종류
		
	//	먹기 시작
		for (int k = 0; k < K; k++) {
			int dish = dishArr[k];
			if(check[k] == 0) cnt++;//처음 먹어본 접시면 종류 cnt++
			check[dish]++;
		}
		
		int max = cnt;
		
		for (int n = 0; n < N; n++) {
			// 맨 앞에 있는 접시는 안먹는걸로 -->check 에서 1 감소 --> 결과 0이 되어버리면? 종류가 줄어듬
			int dish = dishArr[n];
			check[dish]--;
			if(check[dish] == 0) cnt--;
			//새롭게 추가되는 접시는 먹는걸로
			dish = dishArr[(n+K) % N];
			if(check[dish] == 0) cnt++;
			check[dish]++;
			
			max = Math.max(max, cnt);
		}
		
		
//		System.out.println(Arrays.toString(check));
//		return -1;
		return max;
	}
	static String src = "8 30 4 30\n"
			+ "7\n"
			+ "9\n"
			+ "7\n"
			+ "30\n"
			+ "2\n"
			+ "7\n"
			+ "9\n"
			+ "25";
} 
//5
