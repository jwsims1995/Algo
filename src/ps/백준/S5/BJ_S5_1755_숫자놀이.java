package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_1755_숫자놀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int M, N;
	static String[] change = {"zero","one","two","three","four","five","six","seven","eight","nine"}; //int -> String 를 위한 배열
	
	static List<String> list = new ArrayList<>(); // int -> String 을 저장하기 위한 list
	static String[] ans ;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		
		for (int n = M; n <= N; n++) {
			if(1<=n && n < 10) {		//10보다 작은 수는 그 자체를 index 로 사용하여 list.add
				list.add(change[n]);
			}
			else {						//10~99 까지의 수는 일의 자리, 십의자리를 구별하여 list.add
				int il = n%10;
				int sip = n/10;
				
				list.add(change[sip] + " " + change[il]);
			}
		}
		
		//System.out.println(list);	//입력확인

		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.split(" ")[0].equals(o2.split(" ")[0])) {//띄어쓰기를 기준으로 split했을때 10~99수는 두개로 나뉜다. 십의 자리 수가 같을 경우
					System.out.println(o1);
					System.out.println(o2);
					if(o2.split(" ").length == 1) return -1;
					
					return o1.split(" ")[1].compareTo(o2.split(" ")[1]);	// 일의 자리수를 비교하여 사전순으로 정렬
				}
				return o1.compareTo(o2);				//그 외의 경우 바로 비교하여도 되므로 사전순으로 정렬
			}
		});
		
		//System.out.println(list);	//list 확인
		ans = new String[list.size()];		//정답을 담을 배열을 list size만큼 생성
		Arrays.fill(ans, "");				//바로 사용하면 null 값으로 초기화 되므로 ""으로 초기화
		
		for (int i = 0; i < list.size(); i++) {
			String[] tmp = list.get(i).split(" ");		//int->String했던 list에서 띄어쓰기가 있다면 10~99이므로 j=0과 j=1 둘다 계산
			for (int j = 0; j < tmp.length; j++) {		// 띄어쓰기가 없다면 1~9이므로 loop를 j=0일때 한번만 돈다.
				if(j==0) {
					for (int k = 0; k < change.length; k++) {	//k번째 index 를 그대로 ans string배열에 추가
						if(change[k].equals(tmp[j])) {
							ans[i] += k;
						}
					}
				}
				else {//j == 1
					for (int k = 0; k < change.length; k++) {
						if(change[k].equals(tmp[j])) {
							ans[i] += k;						//k번째 index 를 그대로 ans string배열에 추가
						}
					}
				}
			}
			output.append(ans[i] + " ");
			if(i %10 ==9)output.append("\n");		//10개씩 출력위해 줄바꿈 (0부터 index가 시작되므로 i%10 == 9)
		}

		System.out.println(output);
		
	}

	static String src = "1 58";
}
