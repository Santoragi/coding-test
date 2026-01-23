import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int tomatoes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());   //x
        N = Integer.parseInt(st.nextToken());   //y
        H = Integer.parseInt(st.nextToken());   //height

        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        int cnt = 0;
        List<int[]> start = new ArrayList<>();

        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int m = 0; m < M; m++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    if(tomato == 1) {
                        start.add(new int[]{h, n, m});
                    }
                    if(tomato != -1) {
                        cnt++;
                    }
                    box[h][n][m] = tomato;
                }
            }
        }

        tomatoes = cnt;
        System.out.println(bfs(start));
    }


    static int bfs(List<int[]> start){
        Queue<int[]> q = new LinkedList<>();

        for(int[] n : start) {
            int startH = n[0];
            int startY = n[1];
            int startX = n[2];

            q.add(new int[]{startH, startY, startX, 0});
        }

        int cnt = start.size();
        if(cnt == tomatoes) return 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int h = cur[0];
            int y = cur[1];
            int x = cur[2];
            int day = cur[3];

            for(int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nh >= H || nh < 0
                        || ny >= N || ny < 0
                        || nx >= M || nx < 0) continue;

                if(box[nh][ny][nx] == 0 && !visited[nh][ny][nx]) {
                    box[nh][ny][nx] = 1;
                    visited[nh][ny][nx] = true;
                    q.add(new int[]{nh, ny, nx, day + 1});
                    cnt++;

                    if(cnt == tomatoes) return day + 1;
                }
            }
        }

        return -1;
    }

}