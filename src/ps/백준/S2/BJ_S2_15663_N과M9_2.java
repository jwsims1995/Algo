package ps.백준.S2;

import java.util.*;
import java.io.*;

public class BJ_S2_15663_N과M9_2 {

    private static int N, M;
    private static int[] arr;
    private static Set<String> s;
    private static StringBuilder ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = new StringBuilder();
        s = new HashSet<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 순열
        permutation(M, new int[M], 0);
        System.out.print(ans);
    }

    // bitMasking 을 이용한 순열
    public static void permutation(int cnt, int[] selected, int flag){
        if(cnt == 0){
            StringBuilder sb = new StringBuilder();
            for(int num : selected){
                sb.append(num).append(" ");
            }
            String str = sb.toString();
            
            // String 으로 만들고 Set 을 이용하여 중복을 거른다. 
            if(s.contains(str)) return;
            s.add(str);
            
            // 정답 출력 (어차피 30Line에서 정렬을 진행했기 때문에 오름차순으로 등록된다)
            ans.append(str).append("\n");
            return;
        }

        for(int i = 0; i < N; ++i){
            if((flag & (1 << i)) > 0) continue;
            selected[selected.length - cnt] = arr[i];
            permutation(cnt-1, selected, flag | (1 << i));
        }
    }
}