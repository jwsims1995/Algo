
import java.io.*;
import java.util.*;

class Main {
   
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static int N,T;
   static int[][] dp = new int[4][11];
   public static void main(String[] args) throws Exception {
      T = Integer.parseInt(input.readLine());
      
      dp[1][1] = 1;      
   
      dp[1][2] = 1;
      dp[2][2] = 1;
         
      dp[1][3] = 2;
      dp[2][3] = 1;
      dp[3][3] = 1;
      
      for(int i=4;i<11;++i) { // 목표
         dp[1][i] += dp[1][i-1]+dp[2][i-1]+dp[3][i-1];
         dp[2][i] += dp[1][i-2]+dp[2][i-2]+dp[3][i-2];
         dp[3][i] += dp[1][i-3]+dp[2][i-3]+dp[3][i-3];
      }
      
      for(int t=0;t<T;++t) {
         N = Integer.parseInt(input.readLine());
         output.append(dp[1][N]+dp[2][N]+dp[3][N]).append('\n');
      }
      
      System.out.println(output);
   }

}