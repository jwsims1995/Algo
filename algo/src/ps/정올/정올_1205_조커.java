package ps.정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 정올_1205_조커 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, ans, joker, MAX;
	static List<Integer> card = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(num == 0) joker++;
			else if(! isExist(card, num)) card.add(num);
		}
		Collections.sort(card);	
		
		MAX = joker;
		
		
		for (int n = 0; n < N; n++) {
			MAX = Math.max(StraightLen(n, joker), MAX);
		}
		System.out.println(MAX);
	}
	
	private static int StraightLen(int startIdx, int JokerNum) {
		int len = 1; // 최소 카드 수 : 하나
		
		for (int i = startIdx + 1; i < card.size(); i++) { // 시작위치 + 1부터 끝까지 확인
			if (card.get(i) - 1 == card.get(i - 1)) // 앞에 값보다 1 크면 (순차대로면)
				len++;								// 하나 증가한다.
			else if (card.get(i) - card.get(i - 1) - 1 <= JokerNum) {
				// 사이에 필요한 개수가 Joker의 개수보다 작거나 같을때
				JokerNum -= card.get(i) - card.get(i - 1) - 1; // Joker는 필요한 개수만큼 사용
				len += card.get(i) - card.get(i - 1); // 총 길이는 사용한 개수 + 1(바로 다음 수)
			} else // 어디에도 포함되지 않는다면
				break; // 검사 종료
		}

		if (JokerNum > 0) // Joker 카드가 남아있다면
			len += JokerNum; // 모두 길이에 붙여주기

		return len;
	}

	
	
	private static boolean isExist(List<Integer> intList, int value) {
		// intList에서 해당 value가 있으면 true를 return함
		for (int i = 0; i < intList.size(); i++) {
			if (intList.get(i) == value)
				return true;
		}
		return false;
	}
	
	static String src = "8\r\n" + 
			"0 0 0 1 2 6 8 1000";
}
