import java.io.*;
import java.util.*;

public class Main {

    static int N, K, L;
    static int[][] board;

    //우, 하, 좌, 상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    //회전 정보
    static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            board[y][x] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            map.put(t, c);
        }

        simulate();
    }

    static void simulate() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});
        board[0][0] = 2;

        int dir = 0;
        int time = 0;

        while(true) {
            time++;

            int[] head = snake.peekFirst();
            int ny = head[0] + dy[dir];
            int nx = head[1] + dx[dir];

            //벽 충돌
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                System.out.println(time);
                return;
            }

            //뱀 충돌
            if(board[ny][nx] == 2) {
                System.out.println(time);
                return;
            }

            //이동
            if (board[ny][nx] == 1) {
                //사과
                board[ny][nx] = 2;
                snake.addFirst(new int[]{ny, nx});
            }
            else{
                //빈칸
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;

                board[ny][nx] = 2;
                snake.addFirst(new int[]{ny, nx});
            }

            //방향 전환
            if(map.containsKey(time)) {
                char c = map.get(time);

                if(c == 'D') {
                    dir = (dir + 1) % 4;
                }
                else{
                    dir = (dir + 3) % 4;
                }
            }
        }
    }
}