package ps.백준.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_10814_나이순정렬 {
	static class Person implements Comparable<Person>{
		int age;
		String name;
		int num;
		
		public Person(int age, String name, int num) {
			this.age = age;
			this.name = name;
			this.num = num;
		}
		@Override
		public int compareTo(Person o) {
			if(this.age == o.age) {
				return Integer.compare(this.num, o.num);
			}
			return this.age - o.age;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder(); 
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		List<Person> list = new ArrayList<>();
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int age = Integer.parseInt(tokens.nextToken());
			String name = tokens.nextToken();
			int num = n;
			list.add(new Person(age, name, num));
			
		}
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			output.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
		}
		System.out.println(output);
	}
	static String src ="3\n" + 
			"21 Junkyu\n" + 
			"21 Dohyun\n" + 
			"20 Sunyoung";
}
