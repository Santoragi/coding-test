import java.io.*;
import java.util.*;

public class Main {

    static char EMPTY = '.';
    static char WALL = '#';
    static char START = 'S';
    static char END = 'E';
    static String SuccessMessage1 = "Escaped in ";
    static String SuccessMessage2 = " minute(s).";
    static int FailNum = -1;
    static String FailMessage = "Trapped!";

    static int[] dl = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());   //층
            int R = Integer.parseInt(st.nextToken());   //y
            int C = Integer.parseInt(st.nextToken());   //x

            //종료 조건
            if(L == 0 && R == 0 && C == 0) break;


            char[][][] board = new char[L][R][C];
            int[] startPos = new int[3];
            for(int l = 0; l < L; l++) {
                for(int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for(int c = 0; c < C; c++) {
                        char ch = line.charAt(c);
                        if(ch == START) {
                            startPos[0] = l;
                            startPos[1] = r;
                            startPos[2] = c;
                        }

                        board[l][r][c] = ch;
                    }
                }
                br.readLine();
            }

            int result = bfs(startPos, board);
            sb.append(getMessage(result)).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int[] start, char[][][] board) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], start[2], 0});

        int L = board.length;
        int R = board[0].length;
        int C = board[0][0].length;
        boolean[][][] visited = new boolean[L][R][C];
        visited[start[0]][start[1]][start[2]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int l = cur[0];
            int r = cur[1];
            int c = cur[2];
            int cnt = cur[3];

            if(board[l][r][c] == END) {
                return cnt;
            }

            for(int i = 0; i < 6; i++) {
                int nl = l + dl[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nl < 0 || nl >= L ||
                        nr < 0 || nr >= R ||
                        nc < 0 || nc >= C) continue;

                if(visited[nl][nr][nc]) continue;
                if(board[nl][nr][nc] == WALL) continue;

                visited[nl][nr][nc] = true;
                q.add(new int[]{nl, nr, nc, cnt + 1});
            }
        }

        return FailNum;
    }

    public static String getMessage(int x) {
        if(x == FailNum) {
            return FailMessage;
        }
        else {
            return SuccessMessage1 + x + SuccessMessage2;
        }
    }
}