package ps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class 카카오 {
	public int[] solution(String[] id_list, String[] report, int k) {
		// key: 유저
		// value: key 유저를 신고한 유저들
		Map<String, HashSet<String>> hm = new HashMap<>();
		for (int i = 0; i < report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i], " ");
			String user = st.nextToken(); // 신고한 유저
			String reportedUser = st.nextToken(); // 신고당한 유저

			// 동일한 유저에 대한 신고 횟수는 1회로 처리
			HashSet<String> users = new HashSet<>();
			if (hm.get(reportedUser) != null) {
				users.addAll(hm.get(reportedUser));
			}
			users.add(user);

			hm.put(reportedUser, users);
		}

		// 이 유저를 신고한 사람이 k이상이면 정지
		Map<String, Integer> mail = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			mail.put(id_list[i], 0);
		}
		for (String key : hm.keySet()) {
			HashSet<String> hs = hm.get(key);
			if (hs.size() >= k) {
				for (String user : hs) {
					mail.put(user, mail.get(user) + 1);
				}
			}
		}
		int[] answer = new int[id_list.length];

		for (int i = 0; i < mail.size(); i++) {
			answer[i] = mail.get(id_list[i]);
		}

		return answer;
	}

}
