import java.io.*;
import java.util.*;

public class Main {

    static char EMPTY = '.';
    static char WALL = '#';
    static char FIRE = '*';
    static char SANGGEUN = '@';
    static String ErrorMessage = "IMPOSSIBLE";

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static char[][] board;
    static List<int[]> firePos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            firePos = new ArrayList<>();

            int startY = -1;
            int startX = -1;
            for(int i = 0; i < h; i++) {
                String line = br.readLine();
                for(int j = 0; j < w; j++) {
                    char c = line.charAt(j);

                    if(c == SANGGEUN) {
                        startY = i;
                        startX = j;
                    }
                    else if(c == FIRE) {
                        firePos.add(new int[]{i, j});
                    }

                    board[i][j] = c;
                }
            }

            int cnt = bfs(startY, startX);

            if(cnt == -1) {
                sb.append(ErrorMessage).append("\n");
            }
            else {
                sb.append(cnt).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int bfs(int startY, int startX) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX, 0});

        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        visited[startY][startX] = true;

        int time = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];

            //불이 번짐
            if(time == cnt) {
                spread();
                time++;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                //탈출 조건
                if(ny < 0 || ny >= h || nx < 0 || nx >= w) {
                    return cnt + 1;
                }
                if(board[ny][nx] == FIRE || board[ny][nx] == WALL) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx, cnt + 1});
            }
        }

        return -1;
    }

    public static void spread() {
        int h = board.length;
        int w = board[0].length;
        List<int[]> newFirePos = new ArrayList<>();

        for(int[] pos : firePos) {
            int y = pos[0];
            int x = pos[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if(board[ny][nx] == WALL || board[ny][nx] == FIRE) continue;

                board[ny][nx] = FIRE;
                newFirePos.add(new int[]{ny, nx});
            }
        }

        firePos = newFirePos;
    }
}

