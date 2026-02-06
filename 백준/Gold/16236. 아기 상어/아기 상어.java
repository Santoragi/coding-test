import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int N;

    static int EMPTY = 0;
    static int SHARK = 9;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int startY = 0;
        int startX = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                board[i][j] = n;
                if(n == SHARK) {
                    startY = i;
                    startX = j;
                }
            }
        }

        Shark shark = new Shark(startY, startX, 2, 0, 0);

        int time = 0;
        while(true) {
            List<Fish> fishes = findFishes(shark);
            if(fishes.isEmpty()) break;

            Fish best = findBestFish(fishes);

            shark.eatFish(best);
            shark.move(best.y, best.x);

            time += best.dist;
        }

        System.out.println(time);
    }

    static List<Fish> findFishes(Shark shark) {
        Queue<Shark> q = new LinkedList<>();
        visited = new boolean[N][N];

        visited[shark.y][shark.x] = true;
        q.add(shark);

        List<Fish> fishes = new ArrayList<>();
        while(!q.isEmpty()) {
            Shark cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
                if(visited[ny][nx]) continue;

                if(board[ny][nx] < cur.size && board[ny][nx] != EMPTY) {
                    visited[ny][nx] = true;
                    fishes.add(new Fish(ny, nx, board[ny][nx], cur.move + 1));
                    q.add(new Shark(ny, nx, cur.size, cur.cnt, cur.move + 1));
                }

                if(board[ny][nx] == cur.size || board[ny][nx] == EMPTY) {
                    visited[ny][nx] = true;
                    q.add(new Shark(ny, nx, cur.size, cur.cnt, cur.move + 1));
                }
            }
        }

        return fishes;
    }

    static Fish findBestFish(List<Fish> fishes) {

        Fish best = fishes.get(0);
        if(fishes.size() == 1) {
            return best;
        }

        for(Fish fish : fishes) {
            best = fish.betterThan(best) ? fish : best;
        }

        return best;
    }

    static class Shark {
        int y;
        int x;
        int size;
        int cnt;
        int move;

        public Shark(int y, int x, int size, int cnt, int move) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.cnt = cnt;
            this.move = move;
        }

        public void eatFish(Fish fish) {
            if(size <= fish.size) return;

            cnt++;
            if(cnt >= size) {
                cnt = 0;
                size++;
            }
        }

        public void move(int y, int x) {
            board[this.y][this.x] = EMPTY;
            board[y][x] = SHARK;

            this.y = y;
            this.x = x;
            this.move = 0;
        }
    }

    static class Fish {
        int y;
        int x;
        int size;
        int dist;

        public Fish(int y, int x, int size, int dist) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.dist = dist;
        }

        public boolean betterThan(Fish fish) {
            if(fish.dist < dist) return false;
            else if(fish.dist > dist) return true;

            if(fish.y < y) return false;
            else if(fish.y > y) return true;

            if(fish.x < x) return false;
            else if(fish.x > x) return true;

            return true;
        }
    }

}
