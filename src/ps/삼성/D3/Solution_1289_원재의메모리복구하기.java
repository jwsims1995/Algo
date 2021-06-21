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
			char[] line = input.readLine().toCharArray();
			int ans = 0;
			int tmp = '0';
			for (int i = 0; i < line.length; i++) {
				if(line[i] != tmp) {
					ans++;
					tmp = line[i];
				}
			}
			
			output.append("#").append(t).append(" ").append(ans).append("\n");
		}
		//정답 출력
		System.out.println(output);
	}
	
	
	
	//교수님코드
	/*static int solution1(String line) {
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
	}*/
	// 입력을 받아놓자.
	static String src = "2\r\n" + 
			"0011\r\n" + 
			"100";
	
}
