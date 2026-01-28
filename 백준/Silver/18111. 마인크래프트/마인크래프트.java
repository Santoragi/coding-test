import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int N, M, B;
    static int T = Integer.MAX_VALUE;
    static int H = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        int min = Integer.MAX_VALUE, max = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                if(h < min) {
                    min = h;
                }
                if(h > max) {
                    max = h;
                }
                board[i][j] = h;
            }
        }

        for(int i = min; i <= max; i++) {
            minecraft(i);
        }

        System.out.println(T + " " + H);
    }

    static void minecraft(int target) {

        int time = 0;
        int blocks = B;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] > target) {
                    time += (board[i][j] - target) * 2;
                    blocks += board[i][j] - target;
                }
                else if(board[i][j] < target) {
                    time += target - board[i][j];
                    blocks -= target - board[i][j];
                }
            }
        }

        if(blocks >= 0) {
            if(time <= T) {
                T = time;
                H = target;
            }
        }
    }
}