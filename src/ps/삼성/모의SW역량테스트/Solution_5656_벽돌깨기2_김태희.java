import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
* @author taeheekim
*/
public class Solution_5656_벽돌깨기2_김태희 {

	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	private static int N,W,H,min;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0,map); // 구슬떨어뜨리기
			System.out.println("#"+t+" "+min);
		}
	}
	// 중복순열로 구슬 떨어뜨리기
	// boolean : true-모두 깨뜨린 상황
	private static boolean go(int cnt,int[][] map) {//cnt : 구슬을 떨어뜨린 횟수,map : cnt-1 구슬까지의 상태맵
		int result = getRemain(map);
		if(result == 0) { // 모두 빈칸(깨뜨릴 벽돌이 음따!!)
			min = 0;
			return true;
		}
		
		if(cnt == N) {
			min = Math.min(min, result);
			return false;
		}
		
		int[][] newMap = new int[H][W];
		// 매열마다 구슬 떨어뜨리는 시도
		for (int c = 0; c < W; c++) {
			// 해당열에 구슬을 떨어뜨려 맞는 벽돌 찾기
			int r = 0;
			while(r<H && map[r][c]==0) ++r;
			if(r==H) { // 맞는 벽돌 없음(모두 빈칸)
				continue; // 다음 열로 구슬 떨어뜨리기.
			}else {
				// 기존 cnt-1 구슬까지의 상태로 초기화 
				copy(map,newMap);
				// 벽돌 깨뜨리기
				boom(newMap,r,c);
				// 벽돌 내리기(깨지고 난 빈 공간 처리)
				down(newMap);
				// 다음 구슬 던지기
				if(go(cnt+1,newMap)) return true;
			}
		}
		return false;
	}
	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]>0) ++count;
			}
		}
		return count;
	}
	private static void down(int[][] map) {
		
		for (int c = 0; c < W; c++) {
			int r = H-1;
			while(r>=0 && map[r][c]==0) --r;
			if(r<0) continue; // 모두빈칸이면 내릴것이 없으므로 옆열 내리기
			
			r = H-1;
			while(r>0) { // 자신의 위치에 내리기
				if(map[r][c]==0) {// 빈칸이면
					// 직전부터 위쪽 탐색하며 가장 가까운 벽돌 찾기
					int nr = r-1;
					while(nr>0 && map[nr][c]==0) --nr;
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				--r;
			}
		}
	}
	private static void boom(int[][] map,int r,int c) {

		Queue<Point> queue = new LinkedList<Point>();
		if(map[r][c]>1) {
			queue.offer(new Point(r,c,map[r][c]));
		}
		map[r][c] = 0; // 제거처리 (방문처리 효과)
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] != 0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr,nc,map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}
	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}
