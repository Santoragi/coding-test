import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int[][] board;
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

        int year = 0;
        while(true) {
            year++;
            boolean flag = process();
            if(flag) {
                int mountain_cnt = countMountain();
                if (mountain_cnt >= 2) {
                    //출력 후 종료
                    System.out.println(year);
                    break;
                }
                else if(mountain_cnt <= 0) {
                    System.out.println(0);
                    break;
                }
            }
        }
    }

    public static boolean process() {
        int[][] newBoard = new int[N][M];

        //1년동안 녹아서 0이된 지점의 여부
        boolean flag = false;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] > 0) {
                    int zero_cnt = countZero(i, j);

                    newBoard[i][j] = Math.max(board[i][j] - zero_cnt, 0);
                    if(!flag && newBoard[i][j] == 0) flag = true;
                }
            }
        }

        board = newBoard;

        return flag;
    }

    public static int countZero(int y, int x) {
        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(board[ny][nx] == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    public static int countMountain() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && board[i][j] > 0) {
                    bfs(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void bfs(int y, int x, boolean[][] visited) {
        visited[y][x] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny >= N || ny < 0 || nx >= M || nx < 0) continue;
                if(visited[ny][nx]) continue;
                if(board[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
    }
}