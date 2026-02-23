import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static boolean[] choice;
    static int start = 0;
    static int link = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        choice = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int cnt, int idx) {
        if(cnt == N/2) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i == j) continue;
                    if(choice[i] && choice[j]) start += board[i][j];
                    if(!choice[i] && !choice[j]) link += board[i][j];
                }
            }
            min = Math.min(min, Math.abs(start - link));
            start = 0;
            link = 0;
            return;
        }

        if(idx < N) {
            choice[idx] = true;
            dfs(cnt + 1, idx + 1); //선택한 경우
            choice[idx] = false;
            dfs(cnt, idx + 1); //선택하지 않은 경우
        }
    }
}
