package ps.백준.S1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @풀이일 2021. 2. 8.
 * @문제링크  https://www.acmicpc.net/problem/16927
 * @성능  33176   540
 * @분류  $배열,
 * @고려사항 인덱스를 잘 조절해주자.
 */

public class BJ_S1_16927_배열돌리기2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine(), " ");
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        R = Integer.parseInt(tokens.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(input.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }

        // 입력 완료
        int T = Math.min(N, M) / 2;
        for (int t = 0; t < T; t++) {
            int elems = (N-1-2*t)*2 +(M-1-2*t)*2;
            //System.out.println(elems);
            int cnt = R % elems;
            for (int i = 0; i < cnt; i++) {
                rotateFloor(t);
            }
        }

        for (int[] row : map) {
            for (int v : row) {
                output.append(v).append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    static void rotateFloor(int t) {
        int keep = map[t][t];
        // 위에서 왼쪽으로 한 칸씩 이동하기
        for (int c = t + 1; c < M - t; c++) {
            map[t][c - 1] = map[t][c];
        }
        // 오른쪽에서 위로 한 칸씩 이동하기
        for (int r = t + 1; r < N - t; r++) {
            map[r - 1][M - 1 - t] = map[r][M - 1 - t];
        }
        // 아래에서 오른쪽으로 한 칸씩 이동하기
        for (int c = M - 1 - 1 - t; c >= 0 + t; c--) {
            map[N - 1 - t][c + 1] = map[N - 1 - t][c];
        }
        // 왼쪽 아래로 이동하기
        for (int r = N - 1 - 1 - t; r >= t + 1; r--) {
            map[r + 1][t] = map[r][t];
        }
        // keep했던거 끼워주기
        map[t + 1][t] = keep;
    }

    private static String src = "5 4 14\r\n"
            + "1 2 3 4\r\n"
            + "7 8 9 10\r\n"
            + "13 14 15 16\r\n"
            + "19 20 21 22\r\n"
            + "25 26 27 28";
}
