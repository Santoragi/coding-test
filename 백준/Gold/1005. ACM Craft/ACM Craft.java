import java.io.*;
import java.util.*;

public class Main {

    static int T, N, K, W;
    static int[] time;
    static int[] edge;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N + 1];
            edge = new int[N + 1];

            graph = new ArrayList<>();
            for(int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int front = Integer.parseInt(st.nextToken());
                int back = Integer.parseInt(st.nextToken());

                graph.get(front).add(back);
                edge[back]++;
            }

            W = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            int[] result = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                result[i] = time[i];

                if(edge[i] == 0) {
                    q.offer(i);
                }
            }

            while(!q.isEmpty()) {
                int cur = q.poll();

                for(int next : graph.get(cur)) {
                    result[next] = Math.max(result[next], result[cur] + time[next]);

                    edge[next]--;
                    if(edge[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            sb.append(result[W]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
