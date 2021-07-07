package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_2667_단지번호붙이기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output= new StringBuilder();
	static int N, cnt, sum;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	//static List<Integer> list = new LinkedList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1-o2;
		}

	});
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int r= 0; r<N; r++) {
			String line =input.readLine();
			for(int c = 0;c<N; c++) {
				map[r][c] = line.charAt(c)-'0';
			}
		}
		
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		for(int r = 0 ; r<N; r++) {
			for(int c =0 ; c<N; c++) {
				if(map[r][c] == 1 && !visited[r][c]) {
					cnt++;
					sum = 0;
					dfs(r,c);
					pq.add(sum);
				}
			}
		}
		
		output.append(cnt).append("\n");
		while(!pq.isEmpty()) {
			output.append(pq.poll()).append("\n");
		}
		System.out.println(output);
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		sum++;
		for(int d =0; d< deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if(isIn(nr,nc) && !visited[nr][nc] &&map[nr][nc] == 1) {
				dfs(nr,nc);
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N; 
	}

	static String src = "7\n" + 
			"0110100\n" + 
			"0110101\n" + 
			"1110101\n" + 
			"0000111\n" + 
			"0100000\n" + 
			"0111110\n" + 
			"0111000";
}
