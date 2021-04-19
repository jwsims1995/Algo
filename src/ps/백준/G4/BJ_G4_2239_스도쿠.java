package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_2239_스도쿠 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int[][] map = new int[9][9];
	// 0 인 지점들을 관리할 list
	static List<Point> blanks = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		input= new BufferedReader(new StringReader(src));
		for (int r = 0; r < 9; r++) {
			String line = input.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = line.charAt(c)-'0';
				if(map[r][c] == 0) {
					blanks.add(new Point(r,c));
				}
			}
		}//입력완료
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		solve(0);// 0번부터 배치해보자.
	}
	// blanks 에 값을 하나씩 넣어보자.
	static void solve(int idx) {
		// 기저조건
		if(idx == blanks.size()) {
			// 맨 끝에 도달 --> Solution은?
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					output.append(map[r][c]);
				}
				output.append("\n");
			}
			System.out.println(output);
			System.exit(0);
			return;
		}
		//재귀 케이스 -그 Point에 값을 넣어보고 다음으로 진행
		Point p = blanks.get(idx);
		for (int v = 1; v < 10; v++) {
			if(canUse(p.r, p.c, v)) // 할 수 있다면 하자.. --> 가지치
			{
				map[p.r][p.c]= v;
				solve(idx + 1);
				// 안쓴 척 하기
				map[p.r][p.c]= 0; 				
			}
		}
	}
	
	private static boolean canUse(int row, int col, int v) {
		// 해당 열에 중복된거 없나요?
		for (int r = 0; r < 9; r++) {
			if(map[r][col] == v) {
				return false;
			}
		}
		// 해당행에 중복된 거 없나요?
		for (int c = 0; c < 9; c++) {
			if(map[row][c] == v) {
				return false;
			}
		}
		// 해당 사각형에 중복된 거 없나요?
		int sr = row/3 * 3;
		int sc = col/3 * 3;
		
		for (int r = sr; r < sr+3; r++) {
			for (int c = sc; c < sc+3; c++) {
				if(map[r][c] == v) {
					return false;
				}
			}
		}
		
		return true;
	}

	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static String src = "103000509\n"
			+ "002109400\n"
			+ "000704000\n"
			+ "300502006\n"
			+ "060000050\n"
			+ "700803004\n"
			+ "000401000\n"
			+ "009205800\n"
			+ "804000107";
}
