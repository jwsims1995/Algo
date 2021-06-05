import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소금쟁이 {
	static class Sogum{
		int r;
		int c;
		int d;
		
		public Sogum(int r, int c, int d) {
			this.r = r;
			this.c= c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", d=" + d + "]";
		}
		
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=  new StringBuilder();
	static int T, N, S, res;
	static int[][] pond;
	static Sogum[] sogum;
	// 연못밖, 세번째 뛰었을때 머무른 위치와 충돌하면 죽음
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			res = 0;
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			S = Integer.parseInt(tokens.nextToken());
			pond = new int[N][N];
			sogum = new Sogum[S];
			for (int s = 0; s < S; s++) {
				tokens = new StringTokenizer(input.readLine());
				sogum[s] = new Sogum(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
			}
			System.out.println(Arrays.toString(sogum));
			
			for (int s = 0; s < S; s++) {
				if(pond[sogum[s].r][sogum[s].c] == 1) { //점프했는데 그 위치에 있을경우
					continue;
				}
				int r = sogum[s].r;
				int c = sogum[s].c;
				for (int cnt = 3; cnt > 0; cnt--) {
					switch(sogum[s].d) {//상하좌우
					case 1:
						r -= cnt;
						
						if(!isIn(r,c) || pond[r][c] == 1 )break;
						
						if(cnt == 1) pond[r][c] = 1;
						
						break;
						
					case 2:
						r += cnt;
						
						if(!isIn(r,c) || pond[r][c] == 1 )break;
						
						if(cnt == 1) pond[r][c] = 1;
						
						break;
						
					case 3:
						c -= cnt;
						
						if(!isIn(r,c) || pond[r][c] == 1 )break;
						
						if(cnt == 1) pond[r][c] = 1;
						
						break;
						
					case 4:
						c += cnt;
						
						if(!isIn(r,c) || pond[r][c] == 1 )break;
						
						if(cnt == 1) pond[r][c] = 1;
						
						break;
						
					}					
				}
				
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(pond[i][j] == 1) res++;
				}
			}
			output.append("#").append(t).append(" ").append(res).append("\n");
			for (int[] row : pond) {
				System.out.println(Arrays.toString(row));
			}
		}
		System.out.println(output);
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	//3 4 1
	static String src = "3\r\n" + 
			"9 5\r\n" + 
			"6 2 4\r\n" + 
			"1 5 2\r\n" + 
			"0 0 4\r\n" + 
			"6 6 1\r\n" + 
			"2 4 3\r\n" + 
			"11 6\r\n" + 
			"0 0 4\r\n" + 
			"6 0 1\r\n" + 
			"2 4 3\r\n" + 
			"4 2 4\r\n" + 
			"1 5 2\r\n" + 
			"10 8 1\r\n" + 
			"7 5\r\n" + 
			"5 2 1\r\n" + 
			"1 6 2\r\n" + 
			"0 6 3\r\n" + 
			"1 0 2\r\n" + 
			"2 4 4";
}
