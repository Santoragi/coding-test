import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static boolean[] choice;
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
            int score = getScore();
            if(score < min) {
                min = score;
            }
            if(score == 0) {
                System.out.println(score);
                System.exit(0);
            }

            return;
        }

        for(int i = idx; i < N; i++) {
            if(!choice[i]) {
                choice[i] = true;
                dfs(cnt + 1, i + 1);
                choice[i] = false;
            }
        }
    }

    static int getScore() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(choice[i] && choice[j]) {
                    start += board[i][j];
                    start += board[j][i];
                }
                else if(!choice[i] && !choice[j]) {
                    link += board[i][j];
                    link += board[j][i];
                }
            }
        }

        return Math.abs(start - link);
    }
}
