import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int sum = bfs(i, j);
                if(sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }

    static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 1, board[y][x], -1, -1, -1, -1});

        int max = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            int cnt = cur[2];
            int sum = cur[3];
            int py = cur[4];
            int px = cur[5];
            int ppy = cur[6];
            int ppx = cur[7];

            if(cnt == 4) {
                if(sum > max){
                    max = sum;
                }
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny >= N || ny < 0 || nx >= M || nx < 0) continue;

                if(!(ny == py && nx == px) && !(ny == ppy && nx == ppx)) {
                    if(cnt == 2){
                        q.add(new int[]{cy, cx, cnt + 1, sum + board[ny][nx], ny, nx, py, px});
                        q.add(new int[]{ny, nx, cnt + 1, sum + board[ny][nx], cy, cx, py, px});
                    }
                    else{
                        q.add(new int[]{ny, nx, cnt + 1, sum + board[ny][nx], cy, cx, py, px});
                    }
                }
            }
        }

        return max;
    }
}