package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 1.
 * @author Jaewon
 * @see https://www.acmicpc.net/problem/17478
 * @mem
 * @time
 * @caution
 */

public class BJ_S5_17478_재귀함수가뭔가요 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static String story = "\"재귀함수가 뭔가요?\"\r\n" + 
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n" + 
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n" + 
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\r\n";
	
	static String real ="\"재귀함수가 뭔가요?\"\r\n" + 
			"\"재귀함수는 자기 자신을 호출하는 함수라네\"\r\n";
	
	static String end = "라고 답변하였지.\r\n";
	
	static String underBar = "";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(input.readLine());
		solution(T);
	}

	static void solution(int num) {
		if(num == 0) {
			output.append(underBar).append(real);
			return;
			}

		output.append(underBar).append(story);
		underBar+="____";
		solution(--num);
		output.append(end);
		
	}
}
