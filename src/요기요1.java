
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
	static Map<String, Integer> map = new HashMap<>();
	static StringBuilder output = new StringBuilder();

	public String solution(String S, String C) {
		String[] str = S.split("; ");

		for (int s = 0; s < str.length; s++) {
			String[] line = str[s].split(" ");

			// 성
			String fn = line[0].toLowerCase();
			// 이름
			String ln = line[line.length - 1].toLowerCase();
//			
			if (ln.contains("-")) {
				ln = ln.replace("-", "");
			}
			if (ln.length() > 8) {
				ln = ln.substring(0, 8);
			}
			// System.out.print("fn: "+fn);
			// System.out.println(" ln: "+ln);
//			

			map.put(fn + ln, map.getOrDefault(fn + ln, 0) + 1);
			// System.out.println(map);

			if (map.get(fn + ln) > 1) {
				output.append(str[s]).append(" ").append("<").append(fn).append(".").append(ln).append(map.get(fn + ln))
						.append("@").append(C.toLowerCase()).append(".com>; ");
			} else {
				output.append(str[s]).append(" ").append("<").append(fn).append(".").append(ln).append("@")
						.append(C.toLowerCase()).append(".com>; ");
			}

		}
		// System.out.println(output.substring(0, output.length()-2));

		return output.substring(0, output.length() - 2).toString();
	}
}
