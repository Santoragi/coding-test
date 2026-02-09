import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static List<int[]> virus = new ArrayList<>();

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int n =Integer.parseInt(st.nextToken());
                board[i][j] = n;

                if(n == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
        System.out.println(max);
    }
    static void dfs(int cnt) {
        if(cnt == 3) {
            int safe = bfs();
            if(safe > max) {
                max = safe;
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(cnt + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < virus.size(); i++) {
            int[] v = virus.get(i);
            int y = v[0];
            int x = v[1];
            q.add(new int[]{y, x});
        }

        int[][] copy = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                copy[i][j] = board[i][j];
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >= N || ny < 0 || nx >= M || nx < 0) continue;

                if(copy[ny][nx] == 0) {
                    copy[ny][nx] = 2;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copy[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
