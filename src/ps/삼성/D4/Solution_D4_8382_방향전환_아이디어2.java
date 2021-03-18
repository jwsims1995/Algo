package ps.삼성.D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환_아이디어2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
 
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int answer = 0;
 
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int pos[] = new int[4];
            for (int i = 0; i < 4; i++) {
                pos[i] = Integer.parseInt(st.nextToken());
            }
 
            int hdist = Math.abs(pos[2] - pos[0]);			//x pos
            int vdist = Math.abs(pos[3] - pos[1]) ;			//y pos
            int max = Math.max(hdist, vdist);
            if((Math.abs(hdist+vdist))%2==0) answer= max*2;
			else                     answer= max*2-1;
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}



