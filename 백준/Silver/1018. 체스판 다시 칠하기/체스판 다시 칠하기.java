import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N - 7; i++) {
            for(int j = 0; j < M - 7; j++) {
                int cnt = Math.min(bfs(i, j, 'W'), bfs(i, j, 'B'));
                if(cnt < min) {
                    min = cnt;
                }
            }
        }

        System.out.println(min);
    }

    static int bfs(int y, int x, char color) {
        Queue<Info> q = new LinkedList<>();
        boolean[][] visited = new boolean[8][8];
        char[][] copy = new char[8][8];

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                copy[i][j] = board[y + i][x + j];
            }
        }

        int cnt = 0;
        q.add(new Info(0, 0, color));
        if(copy[0][0] != color) {
            cnt++;
        }
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Info cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny >= 8 || ny < 0 || nx >= 8 || nx < 0) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                if(cur.color == copy[ny][nx]) {
                    cnt++;
                    if(copy[ny][nx] == 'W') {
                        q.add(new Info(ny, nx, 'B'));
                    }
                    else {
                        q.add(new Info(ny, nx, 'W'));
                    }
                }
                else {
                    q.add(new Info(ny, nx, copy[ny][nx]));
                }
            }
        }

        return cnt;
    }

    static class Info {
        char color;
        int y;
        int x;

        public Info(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }

}
