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

public class BJ_S5_7568_덩치 {
	static class Student {
		int height, weight;

		public Student(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "height : " + height + "  weight : " + weight;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] rank;
	static Student[] student;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		rank = new int[N];
		student = new Student[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int weight = Integer.parseInt(tokens.nextToken());
			int height = Integer.parseInt(tokens.nextToken());
			student[n] = new Student(weight, height);
		}
//		System.out.println(Arrays.toString(student));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (student[i].height < student[j].height && student[i].weight < student[j].weight) {
//					System.out.println(student[i].toString());
					rank[i]++;
				}
			}
		}
		for(int num : rank) {
			output.append(num+1).append(" ");
		}
		System.out.println(output);
	}

	static String src = "5\n" + "55 185\n" + "58 183\n" + "88 186\n" + "60 175\n" + "46 155";
}
