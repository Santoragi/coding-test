import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int cnt = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);

                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
