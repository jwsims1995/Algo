package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환_BFS {
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1}; // 상하좌우
    static int   x1, x2, y1, y2;
    static int[][] map;
    static Queue<node> q ;
    static boolean[][][] visited ;
    static int answer ;
    private static class node{
        int r,c;
        int direction; // 0 : 세로, 1 : 가로 
        int count;
        node( int r, int c, int direction, int count){
            this.r =r;
            this.c =c;
            this.direction = direction;
            this.count = count;
        }
         
    }
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
         
        st = new StringTokenizer(br.readLine()," ");
        int Tc = Integer.parseInt(st.nextToken());
        for( int tc=1; tc<=Tc; tc++) {
             
            st = new StringTokenizer(br.readLine()," ");
            x1 = Integer.parseInt(st.nextToken())+100;
            y1 = Integer.parseInt(st.nextToken())+100;
            x2 = Integer.parseInt(st.nextToken())+100;
            y2 = Integer.parseInt(st.nextToken())+100;
            q = new LinkedList<>();
             
            map = new int[201][201];
            visited = new boolean[201][201][2]; // 가로 방향, 세로방향
            answer = 0;
             
            //1. 첫 이동은 가로 or 세로
            for( int d=0 ;d<4; d++) {
                int nr = x1 + dr[d];
                int nc = y1 + dc[d];
                 
                if ( !isIn(nr,nc)) continue;
                // 세로이동이라면
                if ( d == 0 || d == 1 ) {
                    visited[x1][y1][0] = true;
                    q.add(new node(nr,nc,0,1)); // 0 : 세로
                } 
                // 가로 이동이라면 
                else {
                    visited[x1][y1][1] = true;
                    q.add(new node(nr,nc,1,1)); // 1 : 가로
                }
            }
            answer = bfs();
             
            System.out.println("#"+tc+" "+answer);
        }
         
    }
     
    private static int bfs() {
         
        while( !q.isEmpty()) {
            node Cur = q.poll();
            int r= Cur.r;
            int c= Cur.c;
            int direction = Cur.direction;
            // 찾으면
            if ( r == x2 && c == y2 ) {
                return Cur.count;
            }
            if( direction == 0) { // 이전에 세로로 이동했다면
                for( int d=2; d<4; d++) { // 가로로 이동하기
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                     
                    if ( !isIn(nr,nc) || visited[nr][nc][1]) continue;
                     
                    visited[nr][nc][ 1] = true;
                    q.add(new node(nr,nc,1, Cur.count+1)); // 1 : 가로
                }
            }
            else if( direction == 1 ) { // 이전에 가로로 이동했다면
                for( int d=0; d<2; d++) { // 세로로 이동하기
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                     
                    if ( !isIn(nr,nc) || visited[nr][nc][0]) continue;
                     
                    visited[nr][nc][0] = true;
                    q.add(new node(nr,nc,0, Cur.count+1)); // 0 : 세로
                }
            }
        }
        return 0;
    }
     
     
    private static boolean isIn(int r, int c) {
        if ( r>=0 && r<201 & c >=0 && c<201) return true;
        return false;
    }
}