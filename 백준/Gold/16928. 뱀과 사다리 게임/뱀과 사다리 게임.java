import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= 100; i++) {
            board[i] = i;
        }

        for(int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        System.out.println(bfs());
    }

    static int bfs() {
        boolean[] visited = new boolean[101];
        Queue<int[]> q = new LinkedList<>();
        visited[1] = true;
        q.add(new int[]{1, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if(pos == 100) {
                return cnt;
            }

            for(int i = 1; i <= 6; i++) {
                int newPos = pos + i;

                if(newPos > 100) continue;
                else newPos = board[pos + i];

                if(!visited[newPos]){
                    visited[newPos] = true;
                    q.add(new int[]{newPos, cnt + 1});
                }
            }
        }

        return 0;
    }
}