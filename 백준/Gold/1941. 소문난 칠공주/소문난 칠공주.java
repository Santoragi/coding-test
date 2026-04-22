import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static char[][] board = new char[5][5];
    static boolean[] chose = new boolean[25];

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            String line = br.readLine();
            for(int j=0;j<5;j++){
                board[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }

    static void dfs(int idx, int depth, int y_cnt){
        if(y_cnt >= 4){
            return;
        }

        if(depth == 7){
            int curIdx = idx - 1;

            if(bfs(curIdx / 5, curIdx % 5)){
                result++;
            }
            return;
        }

        for(int i = idx; i < 25; i++){
            chose[i] = true;
            if(board[i / 5][i % 5] == 'Y'){
                dfs(i + 1, depth + 1, y_cnt+1);
            }else{
                dfs(i + 1, depth + 1, y_cnt);
            }
            chose[i] = false;
        }
    }

    static boolean bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        visited[y][x] = true;
        q.offer(new int[]{y, x});

        int cnt = 1;
        while(!q.isEmpty()){

            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                int nxt = ny * 5 + nx;

                if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
                if(visited[ny][nx]) continue;
                if(!chose[nxt]) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
                cnt++;
            }
        }

        return cnt == 7;
    }
}