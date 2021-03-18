package ps.삼성.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 1.
 * @author Jaewon
 * @see	https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV19AcoKI9sCFAZN&probBoxId=AXdbYpUKxsoDFAUO+&type=PROBLEM&problemBoxTitle=0201&problemBoxCnt=++1+
 * @mem
 * @time
 * @caution
 */

public class Solution_1289_원재의메모리복구하기 {
	//입력과 출력에 필요한 요소들
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//키보드에 발생하는 byte stream을 char로
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력은 키보드에서 src로 살짝 바꿔놓자
		input = new BufferedReader(new StringReader(src));
		// 테케 개수
		int T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			String line = input.readLine();
			int answer = 0;
			answer = solution1(src);
			//알고리즘을 작성한다.
//			char flag = line.charAt(0);
//			answer = (flag == '0')? 0 : 1;
//			for(int i=1; i<line.length();i++) {
//				flag = line.charAt(i-1);
//				if(flag != line.charAt(i)) {
//					answer++;
//				}
//			}
			//
			output.append("#").append(t).append(" ").append(answer).append("\n");
		}
		//정답 출력
		System.out.println(output);
	}
	
	
	
	//교수님코드
	static int solution1(String line) {
		boolean [] datas = new boolean[line.length()];
		for(int i = 0; i<datas.length; i++) {
			datas[i] = line.charAt(i) =='1'; // 1이면 true, 아니면 false
		}
		int cnt = 0;
		for(int i=0; i<datas.length; i++) {
			if(datas[i]) {
				cnt++;
				for(int j=i+1; j<datas.length; j++) {
					datas[j] = !datas[j];
				}
			}
		}
		return cnt;
	}
	// 입력을 받아놓자.
	static String src = "2\r\n" + 
			"0011\r\n" + 
			"100";
	
}
