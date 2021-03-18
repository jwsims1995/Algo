package ps.백준.S5;
/**
 * @since 2021. 3. 16.
 * @author Jaewon
 * @see
 * @mem
 * @time
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_1316_그룹단어체커 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, ans;
	static boolean flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		for (int n = 0; n < N; n++) {
			boolean[] visited = new boolean[26]; 
			char[] line = input.readLine().toCharArray();
			check(line, visited);
		}
		System.out.println(ans);
	}
	private static void check(char[] line, boolean[] visited) {
		char pre = line[0];
		for (int i = 1; i < line.length; i++) {
			if(visited[line[i]-'a']) {
				return;
			}
			if(pre == line[i])continue;
			else {
				visited[pre - 'a'] = true;
				pre = line[i];
			}
		}
		ans++;
	}
	static String src = "3\r\n" + 
			"happy\r\n" + 
			"new\r\n" + 
			"year";
}
