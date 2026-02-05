import java.io.*;
import java.util.*;

public class Main {

    static class Block {
        int y, x;
        Block(int y, int x) { this.y = y; this.x = x; }
    }

    static class Group {
        List<Block> blocks = new ArrayList<>();
        int rainbowCnt;
        int stdY, stdX; // 기준 블록 (무지개 제외, y최대 -> x최대)
        int size() { return blocks.size(); }
    }

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static final int BLACK = -1;
    static final int RAINBOW = 0;
    static final int EMPTY = -2;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        double score = 0;

        while (true) {
            visited = new boolean[N][N];
            Group best = null;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && board[i][j] > 0) {
                        Group g = bfs(i, j);
                        if (g.size() < 2) continue;
                        if (best == null || better(g, best)) best = g;
                    }
                }
            }

            if (best == null) break;

            for (Block b : best.blocks) board[b.y][b.x] = EMPTY;
            score += Math.pow(best.size(), 2);

            gravity();
            rotate();
            gravity();
        }

        System.out.println((int)score);
    }

    static boolean better(Group a, Group b) {
        if (a.size() != b.size()) return a.size() > b.size();
        if (a.rainbowCnt != b.rainbowCnt) return a.rainbowCnt > b.rainbowCnt;
        if (a.stdY != b.stdY) return a.stdY > b.stdY;
        return a.stdX > b.stdX;
    }

    static Group bfs(int sy, int sx) {
        int color = board[sy][sx];
        Group g = new Group();

        Queue<Block> q = new ArrayDeque<>();
        List<Block> rainbows = new ArrayList<>();

        q.add(new Block(sy, sx));
        visited[sy][sx] = true;
        g.blocks.add(new Block(sy, sx));

        g.stdY = sy;
        g.stdX = sx;

        while (!q.isEmpty()) {
            Block cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                int v = board[ny][nx];
                if (v == BLACK || v == EMPTY) continue;
                if (visited[ny][nx]) continue;

                if (v == RAINBOW || v == color) {
                    visited[ny][nx] = true;
                    Block nb = new Block(ny, nx);
                    q.add(nb);
                    g.blocks.add(nb);

                    if (v == RAINBOW) {
                        g.rainbowCnt++;
                        rainbows.add(nb);
                    } else {
                        if (ny < g.stdY || (ny == g.stdY && nx < g.stdX))  {
                            g.stdY = ny;
                            g.stdX = nx;
                        }
                    }
                }
            }
        }

        for (Block r : rainbows) visited[r.y][r.x] = false;

        return g;
    }

    static void gravity() {
        for (int x = 0; x < N; x++) {
            for (int y = N - 2; y >= 0; y--) {
                if (board[y][x] == BLACK || board[y][x] == EMPTY) continue;
                int ny = y;
                while (ny + 1 < N && board[ny + 1][x] == EMPTY) {
                    board[ny + 1][x] = board[ny][x];
                    board[ny][x] = EMPTY;
                    ny++;
                }
            }
        }
    }

    static void rotate() {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[i][j] = board[j][N - 1 - i];
            }
        }
        board = newBoard;
    }
}
