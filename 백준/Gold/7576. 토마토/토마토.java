import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] box;
    static boolean[][] visited;
    static int tomatoes;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   //x
        N = Integer.parseInt(st.nextToken());   //y
        box = new int[N][M];
        visited = new boolean[N][M];

        int ctn = 0;
        List<int[]> start = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int n = Integer.parseInt(line.nextToken());
                box[i][j] = n;
                if(n == 0) ctn++;
                else if(n == 1) {
                    ctn++;
                    start.add(new int[]{i, j});
                }
            }
        }
        tomatoes = ctn;

        System.out.println(bfs(start));


    }

    static int bfs(List<int[]> start){
        Queue<int[]> q = new LinkedList<>();
        for(int[] n : start){
            int startY = n[0], startX = n[1];

            q.add(new int[]{startY, startX, 0});
            visited[startY][startX] = true;
        }

        int ctn = start.size();
        if(ctn == tomatoes) return 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int day = cur[2];

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                    if(!visited[ny][nx] && box[ny][nx] == 0){
                        q.add(new int[]{ny, nx, day + 1});
                        ctn++;
                        if(ctn == tomatoes) return day + 1;
                        box[ny][nx] = 1;
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return -1;
    }
}
