package ps.백준.S1;

import java.io.*;
import java.util.*;

public class BJ_S1_9205_맥주마시면서걸어가기2 {
	static class Location{
		int x,  y;
		
		public Location(int x, int y) {
			this.x =x;
			this.y = y;
		}
	}
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N;
	static Location start;
	static Location[] convenient;
	static boolean[] visited;
	static Location end;
    public static void main(String args[]) throws Exception {
    	input = new BufferedReader(new StringReader(src));
    	T= Integer.parseInt(input.readLine());
    	for(int t=0 ; t<T; t++) {
    		boolean isHappy = false;
    		N = Integer.parseInt(input.readLine());
    		convenient= new Location[N];
    		visited= new boolean[N];
    		tokens =new StringTokenizer(input.readLine());
    		start = new Location(Integer.parseInt(tokens.nextToken())/50,Integer.parseInt(tokens.nextToken())/50);
    		for (int n = 0; n < N; n++) {
    			tokens =new StringTokenizer(input.readLine());
        		convenient[n] = new Location(Integer.parseInt(tokens.nextToken())/50,Integer.parseInt(tokens.nextToken())/50);
			}
    		tokens =new StringTokenizer(input.readLine());
    		end = new Location(Integer.parseInt(tokens.nextToken())/50,Integer.parseInt(tokens.nextToken())/50);
    		
    		Queue<Location> queue = new LinkedList<>();
    		queue.add(start);
    		while(!queue.isEmpty()) {
    			Location now = queue.poll();
    			for(int n=0; n<N; n++) {
    				if(now.equals(end)) {
    					isHappy = true;
    					break;
    				}
    				if(!visited[n] && Math.abs(now.x - convenient[n].x) + Math.abs(now.y - convenient[n].y) <= 20 ) {
    					visited[n] = true;
    					queue.add(convenient[n]);
    				}
    			}
    			
    		}
    		
    		if(isHappy) output.append("happy\n");
    		else output.append("sad\n");
    		
    	}
    	System.out.println(output);
    }
    
    static String src ="2\r\n" + 
    		"2\r\n" + 
    		"0 0\r\n" + 
    		"1000 0\r\n" + 
    		"1000 1000\r\n" + 
    		"2000 1000\r\n" + 
    		"2\r\n" + 
    		"0 0\r\n" + 
    		"1000 0\r\n" + 
    		"2000 1000\r\n" + 
    		"2000 2000";
}