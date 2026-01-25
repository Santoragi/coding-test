import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] dx = {-1, 1};
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];

        Queue<int[]> q = new LinkedList<>();
        visited[N] = true;
        q.add(new int[]{N, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int time = cur[1];

            if(pos == K) System.out.println(time);

            for(int i = 0; i < 2; i++) {
                int newPos = pos + dx[i];

                if(newPos < 0 || newPos > 100000) continue;

                if(!visited[newPos]) {
                    visited[newPos] = true;
                    q.add(new int[]{newPos, time + 1});
                }
            }

            int newPos = pos * 2;
            if(newPos < 0 || newPos > 100000) continue;

            if(!visited[newPos]) {
                visited[newPos] = true;
                q.add(new int[]{newPos, time + 1});
            }
        }
    }
}