import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 좋은아침 {
	static char[] src = { 'a', 'b', 'c', 'd' };
	static boolean[] bools = { true, false };

	public static void main(String[] args) {
		// 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("부분집합");
		powerset(4, new boolean[4]);
		// 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
		System.out.println("조합");
		makeCombination(3, new char[3], 0);
		// 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("순열");
		makePermutation(3, new char[3], new boolean[4]);
	}

	static void powerset(int toChoose, boolean[] choosed) {
		if(toChoose == 0) {
			print(choosed);
			return;
		}
		
		choosed[choosed.length - toChoose] = true;
		powerset(toChoose-1, choosed);
		choosed[choosed.length - toChoose] = false;
		powerset(toChoose-1, choosed);
		
	}

	private static void print(boolean[] choosed) {
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < choosed.length; i++) {
			if (choosed[i]) {
				list.add(src[i]);
			}
		}
		System.out.println(list);
	}

	static void makeCombination(int toChoose, char[] choosed, int idx) {
		if(toChoose == 0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		for (int i = idx; i < src.length; i++) {
			choosed[choosed.length - toChoose] = src[i];
			makeCombination(toChoose-1, choosed, i+1);
		}
	}

	static void makePermutation(int toChoose, char[] choosed, boolean[] visited) {
		if(toChoose == 0) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		for (int i = 0; i < choosed.length; i++) {
			if(!visited[i]) {
				choosed[choosed.length - toChoose] = src[i];
				visited[i] = true;
				makePermutation(toChoose-1, choosed, visited);
				visited[i] = false;
			}
		}
		
	}
}
