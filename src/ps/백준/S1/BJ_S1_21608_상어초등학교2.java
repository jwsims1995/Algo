package ps.백준.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_21608_상어초등학교2 {
	static class Student implements Comparable<Student>{
		int r, c, score, empty;

		public Student(int r, int c, int score, int empty) {
			this.r = r;
			this.c = c;
			this.score = score;
			this.empty = empty;
		}

		@Override
		public int compareTo(Student o) {
			if(this.score != o.score) return o.score - this.score;
			if(this.empty != o.empty) return o.empty - this.empty;
			if(this.r != o.r)return this.r - o.r;
			return this.c - o.c;
		}
		
		@Override
		public String toString() {
			return "r :" + this.r +" c :" + this.c +"  score:" + this.score +" empty :" + this.empty; 
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, result;
	static int[][] info;
	static int[][] score, empty;
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		info = new int[N * N][5];
		int[][] map = new int[N][N];
		for (int i = 0; i < N * N; i++) {
			tokens = new StringTokenizer(input.readLine());
			info[i][0] = Integer.parseInt(tokens.nextToken()); // 학생 번호

			info[i][1] = Integer.parseInt(tokens.nextToken()); // 좋아하는 학생 번호
			info[i][2] = Integer.parseInt(tokens.nextToken());
			info[i][3] = Integer.parseInt(tokens.nextToken());
			info[i][4] = Integer.parseInt(tokens.nextToken());
		}
		
		map[1][1] = info[0][0];
//		score = new int[N][N];
		empty = new int[N][N];
		findEmpty(); // 주변에 빈칸 구하기

		for (int i = 1; i < N * N; i++) {

			findPos(i, map);

		}
//		for (int[] row : empty) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println();
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
		}
		
		for(int i=0; i<info.length;i++) {
			
			findResult(i, map);
			
		}
		
		System.out.println(result);
	}

	private static void findResult(int i, int[][] map) {
		int num = info[i][0];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == num) {
					int score = 0;
					for(int d=0; d<deltas.length; d++) {
						int nr = r+deltas[d][0];
						int nc = c+deltas[d][1];
						if (isIn(nr, nc) && (map[nr][nc] == info[i][1] || map[nr][nc] == info[i][2]
								|| map[nr][nc] == info[i][3] || map[nr][nc] == info[i][4])) {
							score++;
						}
					}
					if(score == 1) result+=1;
					else if(score == 2) result+=10;
					else if(score == 3) result+=100;
					else if(score == 4) result+=1000;
					return;
				}

			} 
		}
	}

	private static void findPos(int i, int[][] map) {
		List<Student> list = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] != 0) continue;
				int score =0;
				// 주변에 좋아하는애 몇명?
				for (int d = 0; d < deltas.length; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					if (isIn(nr, nc) && (map[nr][nc] == info[i][1] || map[nr][nc] == info[i][2]
							|| map[nr][nc] == info[i][3] || map[nr][nc] == info[i][4])) {
						score++;
					}
				}
				list.add(new Student(r,c,score,empty[r][c]));
			}
		}
		Collections.sort(list);
//		System.out.println(info[i][0]);
//		System.out.println(list);
		int r= list.get(0).r;
		int c= list.get(0).c;
		map[r][c] = info[i][0];
		
		//map 값을 업데이트해주면 4방 입장에선 빈칸이 하나 없어진거니까
		for(int d=0; d<deltas.length; d++) {
			int nr= list.get(0).r + deltas[d][0];
			int nc= list.get(0).c + deltas[d][1];
			if(isIn(nr,nc)) {
				empty[nr][nc]--;
			}
		}
	}

	private static void findEmpty() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (r == 0 && c == 0 || r == N - 1 && c == 0 || r == N - 1 && c == N - 1 || r == 0 && c == N - 1)
					empty[r][c] = 2;
				else if (r == 0 || r == N - 1 || c == 0 || c == N - 1)
					empty[r][c] = 3;
				else
					empty[r][c] = 4;
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	static String src = "4\n" + 
			"1 1 2 3 4\n" + 
			"2 1 2 3 4\n" + 
			"3 1 2 3 4\n" + 
			"4 1 2 3 4\n" + 
			"5 1 2 3 4\n" + 
			"6 1 2 3 4\n" + 
			"7 1 2 3 4\n" + 
			"8 1 2 3 4\n" + 
			"9 1 2 3 4\n" + 
			"10 1 2 3 4\n" + 
			"11 1 2 3 4\n" + 
			"12 1 2 3 4\n" + 
			"13 1 2 3 4\n" + 
			"14 1 2 3 4\n" + 
			"15 1 2 3 4\n" + 
			"16 1 2 3 4\n";
}
