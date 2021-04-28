package ps.백준.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_2239_스도쿠_백트래킹 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int[][] map = new int[9][9];
	static List<Point> list = new ArrayList<>();

	// 0인 지점들을 관리할 list
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		for (int r = 0; r < 9; r++) {
			String line = input.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = line.charAt(c) - '0';
				if (map[r][c] == 0)
					list.add(new Point(r, c));
			}
		} // 입력 완료
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		} //입력 확인

		sol(0);

	}

	private static void sol(int cnt) {
		
		if(cnt == list.size()) {
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
		
		Point p = list.get(cnt);
		
			for (int v = 1; v < 10; v++) {
				if(canGo(p.r, p.c , v)) {
					map[p.r][p.c] = v; 
					sol(cnt+1);
					map[p.r][p.c] = 0 ; 
				}
			}
		}
	
	
	static boolean canGo(int row, int col, int v) {

		// 같은 열(col)에 중복된게 있냐
		for (int r = 0; r < 9; r++) {
			if(map[r][col]==v) return false;
			
		}
		// 열(col)이 중복
		for (int c = 0; c < 9; c++) {
			if(map[row][c]==v) return false;	
		}
		// 3x3 이 중복
		int nr = row/3;
		int nc = col/3;
		for (int r = nr*3; r < nr*3+3; r++) {
			for (int c = nc*3; c < nc*3+3; c++) {
				if(map[r][c] == v) return false;
			}
		}
		return true;
	}

	static String src = "103000509\n" + "002109400\n" + "000704000\n" + "300502006\n" + "060000050\n" + "700803004\n"
			+ "000401000\n" + "009205800\n" + "804000107";
}
