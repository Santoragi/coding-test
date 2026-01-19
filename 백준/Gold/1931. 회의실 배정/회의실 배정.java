import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 if(o1[1] == o2[1]) {
                     return o1[0] - o2[0];
                 }

                 return o1[1] - o2[1];
             }
        });

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end});
        }

        int cnt = 0;
        int prev_end = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[0] >= prev_end) {
                cnt++;
                prev_end = cur[1];
            }
        }

        System.out.println(cnt);
    }
}