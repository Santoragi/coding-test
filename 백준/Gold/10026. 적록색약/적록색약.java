import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        visited = new boolean[N][N];


        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        int normal_cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    normal_cnt++;
                }
            }
        }

        visited = new boolean[N][N];
        int odd_cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    odd_cnt++;
                }
            }
        }

        System.out.println(normal_cnt + " " + odd_cnt);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        char cur = board[y][x];

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;

            if(cur == board[ny][nx] && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

}