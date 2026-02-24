import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        public int compare(int[] o1, int[] o2) {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{start, end});
        }

        int cnt = 0;
        int last = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[0] >= last) {
                cnt++;
                last = cur[1];
            }
        }

        System.out.println(cnt);
    }
}
