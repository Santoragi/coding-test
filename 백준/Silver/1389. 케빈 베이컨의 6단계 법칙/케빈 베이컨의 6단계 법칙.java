import java.io.*;
import java.util.*;

public class Main {

    static int[][] relation;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relation = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            relation[A][B] = 1;
            relation[B][A] = 1;
        }

        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 1; i <= N; i++) {
            int result = bfs(i);
            if(result < min) {
                min = result;
                idx = i;
            }
        }

        System.out.println(idx);
    }

    static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N + 1];

        q.add(new int[]{start, 0});
        visited[start] = true;

        int result = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int cnt = cur[1];

            for(int i = 1; i <= N; i++) {
                if(i == idx) continue;
                if(relation[idx][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    result += cnt + 1;
                    q.add(new int[]{i, cnt + 1});
                }
            }
        }

        return result;
    }
}