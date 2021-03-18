package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 9.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

public class Solution_1233_사칙연산유효성검사_풀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, answer;
	static String [] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(input.readLine());
			tree = new String[N+1];
			for (int n = 1; n <= N; n++) {
				tokens = new StringTokenizer(input.readLine());
				tokens.nextToken();// 버림
				tree[n] = tokens.nextToken();
			}//트리완성
			// root node 부터 탐색해보자.
			postOrder(1);
			output.append(String.format("# %d %d%n", t, answer));
		}
		System.out.println(output);
	}
	//트리를 탐색하자. 
	
	/**
	 * 트리를 탐색하자. 파라미터는 서브 트리의 root node
	 * @param i
	 */
	private static void postOrder(int i) {
		// 종료 조건 - 크기를 벗어나진 못한다.
		if(i > N) {
			return;
		}
		//i에 해당하는 값은?
		String node = tree[i];
		// 왼쪽 자식
		postOrder(2*i);
		// 오른쪽 자식
		postOrder(2*i +1);
		
		//이제 나를 이용해서 뭔가 써볼까?
		// 나는 연산자인가?
		// 연산자인 경우...
		if("+-*/".contains(node)) {
			// 자식이 하나라도 없으면 안돼!!
			if(i*2>N || i*2+1>N) {
				answer = 0;
				return;
			}
			//자식은 있어.. 근데 이넘들은 다 피연산자여야해..
			else{
				String left = tree[i*2];
				String right = tree[i*2+1];
				if("+-*/".contains(left) || "+-*/".contains(right)) {
					answer = 0;
					return;
				}
				// 여기까지 떨어졌으면 괜춘~
				tree[i] = "0"; // 연산 결과를 넣어주자. 정확한 값 말고 그냥 피연산자다!
			}
		}
		// 피연산자인 경우 - 자식이 없어야한다.
		else {
			if(i*2<=N || i*2+1<=N) {
				answer= 0;
				return;
			}
		}
	}
}
