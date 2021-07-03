package ps.백준.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_15671_오델로_최성훈 {
   /**
     *@since 2021. 6. 29.
     *@author skyworking
     *@see
     *@time 오후 3:04:31
     *@caution
     */
   
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder sb = new StringBuilder();
   static int N;
   static char[][] arr = new char[7][7];
   
   static int[] dx = {-1,-1,0,1,1,1,0,-1};
   static int[] dy = {0,1,1,1,0,-1,-1,-1};
   
   
   public static void main(String[] args) throws Exception{
	   br = new BufferedReader(new StringReader(src));
	   N = Integer.parseInt(br.readLine());
      
      for(int i=1;i<=6;++i) Arrays.fill(arr[i], '.');
      
      arr[3][3] = 'W';
      arr[3][4] = 'B';
      arr[4][3] = 'B';
      arr[4][4] = 'W';
      
      boolean isBlackTurn = true;
      
      for(int i=0;i<N;++i) {
         StringTokenizer st = new StringTokenizer(br.readLine()," ");
         int r = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());   
         
         placeStone(r,c,isBlackTurn);

         isBlackTurn=!isBlackTurn;
      }
      printing();
      

   }


   private static void printing() {
      int blackCnt = 0;
      int whiteCnt = 0;
      for(int i=1;i<7;++i) {
         for(int j=1;j<7;++j) {
            char c= arr[i][j];
            
            if(c=='B') blackCnt++;
            else if(c=='W') whiteCnt++;
            
            sb.append(c);
         }sb.append('\n');
      }
      
      if(blackCnt>whiteCnt) sb.append("Black\n");
      else sb.append("White\n");
      System.out.println(sb);
   
   }


   private static void placeStone(int r, int c, boolean isBlackTurn) {
      char stone = isBlackTurn?'B':'W';
      char enemy = isBlackTurn?'W':'B';
      
      arr[r][c] = stone;
      
      for(int d=0;d<8;++d) {
         flipStone(r,c,d,stone,enemy);
      }
      
   }
   
   private static void flipStone(int x, int y, int d, char stone, char enemy) {
      int cnt = 1;
      while(true) {
         int nx = x+dx[d]*cnt;
         int ny = y+dy[d]*cnt;
         if(!isRange(nx, ny)) return;
         if(arr[nx][ny]=='.') return;
         else if(arr[nx][ny]==stone) {
            cnt--;
            break;
         }
         
         cnt++;
      }

      while(cnt!=0) {
         int nx = x+dx[d]*cnt;
         int ny = y+dy[d]*cnt;
         arr[nx][ny] = stone;
         cnt--;
      }
   }


   private static boolean isRange(int nx,int ny) {
      return nx>=1 && nx<=6 && ny>=1 && ny<=6;
   }
	static String src = "6\r\n" + "3 2\r\n" + "4 2\r\n" + "5 3\r\n" + "2 2\r\n" + "2 1\r\n" + "3 5";

}