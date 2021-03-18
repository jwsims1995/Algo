import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	// 임대료 A, 1개 생산비 B
	static long A, B, C;
	static long ans;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		long margin = C - B;
		if (margin <= 0)
			ans=-1;
		else {
			ans = A / margin +1;
		}
		System.out.println(ans);
	}
}
