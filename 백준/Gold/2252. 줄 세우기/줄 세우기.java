import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] edge;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edge = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            graph.get(front).add(back);
            edge[back]++;
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(edge[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for(int next : graph.get(cur)) {
                edge[next]--;
                if(edge[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(sb.toString());

    }
}
