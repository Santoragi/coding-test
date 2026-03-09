import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parents;   //부모 노드의 번호를 담는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v).add(w);
            graph.get(w).add(v);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : graph.get(cur)) {
                if(visited[next]) continue;

                visited[next] = true;
                parents[next] = cur;
                q.add(next);
            }
        }
    }
}