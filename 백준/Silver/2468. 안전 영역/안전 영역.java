import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxH = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;
                if(h > maxH) {
                    maxH = h;
                }
            }
        }

        int height = 0;
        int max = 0;
        while(height <= maxH) {
            int cnt = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;
                    if(map[i][j] <= height)  continue;
                    cnt++;
                    dfs(height, i, j);
                }
            }
            height++;

            if(cnt > max) {
                max = cnt;
            }
        }

        System.out.println(max);
    }

    static void dfs(int h, int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
            if(visited[ny][nx]) continue;
            if(map[ny][nx] <= h) continue;

            visited[ny][nx] = true;
            dfs(h, ny, nx);
        }
    }
}
