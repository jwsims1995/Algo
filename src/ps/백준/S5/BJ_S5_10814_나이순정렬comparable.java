package ps.백준.S5;
/**
 * @since 2021. 2. 9.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.*;
import java.util.*;

public class BJ_S5_10814_나이순정렬comparable {
	
	static class Member implements Comparable<Member>{
		int age;
		String name;
		int order;
		
		public Member(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}

		@Override
		public int compareTo(Member o) {
			if(o.age == this.age) return this.order - o.order;
			return Integer.compare(this.age, o.age);
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static Member[] members;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		members = new Member[N];
		for(int n = 0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			Member member = new Member(Integer.parseInt(tokens.nextToken()), tokens.nextToken(), n);
			members[n] = member;
		}
//		for (int i = 0; i < members.length; i++) {
//			output.append(members[i].age).append(" ").append(members[i].name).append("\n");
//		}
//		output.append("\n");
		Arrays.sort(members);
		for (int i = 0; i < members.length; i++) {
			output.append(members[i].age).append(" ").append(members[i].name).append("\n");
		}
		output.append("\n");
		System.out.println(output);
	}
	static String src ="3\r\n" + 
			"21 Junkyu\r\n" + 
			"21 Dohyun\r\n" + 
			"20 Sunyoung";
}
