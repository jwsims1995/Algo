import java.io.*;
import java.util.*;

public class 신한3 {

   static int N;
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws Exception{
       N = Integer.parseInt(input.readLine());
       
       int[] arr = new int[N];
       StringTokenizer st = new StringTokenizer(input.readLine());
       for(int i=0;i<N;++i) {
          arr[i] = Integer.parseInt(st.nextToken());
       }
       
       Arrays.sort(arr);
       
       Set<Integer> set = new HashSet<>();
       for(int num : arr) {
          if(!set.contains(num)) {
             set.add(num);
             output.append(num).append(" ");
          }
       }
       
       System.out.println(output);
    }

    
}