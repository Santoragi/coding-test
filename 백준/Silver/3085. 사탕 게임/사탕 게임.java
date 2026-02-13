import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};

    static int C = 1;
    static int P = 2;
    static int Z = 3;
    static int Y = 4;

    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                char c = line.charAt(j);

                switch(c) {
                    case 'C': board[i][j] = C;
                        break;
                    case 'P': board[i][j] = P;
                        break;

                    case 'Z': board[i][j] = Z;
                        break;

                    case 'Y': board[i][j] = Y;
                        break;
                }
            }
        }

        calc();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                change(i, j);
            }
        }

        System.out.println(max);
    }

    static void change(int y, int x) {
        for(int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= N || nx >= N) continue;
            if(board[y][x] == board[ny][nx]) continue;

            int temp = board[ny][nx];
            board[ny][nx] = board[y][x];
            board[y][x] = temp;

            calc();

            //개수 검사 후 복구
            board[y][x] = board[ny][nx];
            board[ny][nx] = temp;
        }
    }

    static void calc() {

        int count = 0;
        for(int i = 0; i < N; i++) {
            int cnt1 = 1;
            int cnt2 = 1;
            int prev1 = board[i][0];
            int prev2 = board[0][i];
            for(int j = 1; j < N; j++) {
                if(prev1 == board[i][j]) {
                    cnt1++;
                    if(cnt1 > count) {
                        count = cnt1;
                    }
                }
                else {
                    prev1 = board[i][j];
                    cnt1 = 1;
                }

                if(prev2 == board[j][i]) {
                    cnt2++;
                    if(cnt2 > count) {
                        count = cnt2;
                    }
                }
                else {
                    prev2 = board[j][i];
                    cnt2 = 1;
                }
            }
        }

        if(count > max) {
            max = count;
        }
    }

}
