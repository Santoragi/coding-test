import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++) {
            graph[i][i] = -1;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph[n][m] = 1;
            graph[m][n] = 1;
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    static void bfs(int start) {
        StringBuilder sb = new StringBuilder();
        sb.append(start).append(" ");
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 1; i <= N; i++) {
                if(graph[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    sb.append(i).append(" ");
                }
            }
        }

        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int i = 1; i <= N; i++) {
            if(graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}