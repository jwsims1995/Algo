
package ps.정올;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
 
public class 정올_1681_해밀턴순환회로 {
    static int[][]arr;
    static boolean[]visited;
    static int min, sum, N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	br = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for(int x = 0; x<N; x++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for(int y = 0; y<N; y++) {
                arr[x][y]=Integer.parseInt(st.nextToken());
            }
        }
        min = 123415098;
        for(int j = 1; j<N; j++) { 
            visited = new boolean[N];
            sum = 0;
            if(arr[0][j]!=0) {
                dfs(0,j,1);
            }
        }
        System.out.println(min);
    }
    public static void dfs(int x, int y, int cnt) {
        if(sum>min) {
            return;
        }
        sum = sum + arr[x][y];  
        visited[x] = true; 
        if(cnt==(N-1)) {
            sum = sum + arr[y][0];   
            if(arr[y][0]==0) {  
                return;
            }
            min = Math.min(min, sum);
            sum = sum - arr[y][0];  
            return;
        }
        
        
        for(int i = 0; i<N; i++) {
            if(!visited[i] && arr[y][i]!=0 &&(sum<min)) {  
                dfs(y,i,cnt+1);
                sum = sum - arr[y][i]; 
                visited[i] = false; 
            }
        }
    }
    static String src = "5\r\n" + 
    		"0 14 4 10 20\r\n" + 
    		"14 0 7 8 7\r\n" + 
    		"4 5 0 7 16\r\n" + 
    		"11 7 9 0 2\r\n" + 
    		"18 7 17 4 0";
}