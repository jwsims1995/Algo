package ps.백준.B4;

import java.io.*;
import java.util.*;

public class BJ_B4_14470_전자레인지 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int A, B,C,D,E, time, temp;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        A = Integer.parseInt(input.readLine());
        B = Integer.parseInt(input.readLine());
        C = Integer.parseInt(input.readLine());
        D = Integer.parseInt(input.readLine());
        E = Integer.parseInt(input.readLine());
        temp = A;

        while(true){
        	if(temp == B) break;
            
        	if(temp == 0){
        		time+=D;
        	}
            if(temp<0){
                time+=C;
                temp++;
            }
            else{
                time+=E;
                temp++;
            }
            
            
        }
        System.out.println(time);
    }

    static String src = "35\r\n" + 
    		"92\r\n" + 
    		"31\r\n" + 
    		"50\r\n" + 
    		"11";
}
