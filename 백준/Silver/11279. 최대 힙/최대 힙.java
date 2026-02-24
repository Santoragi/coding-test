import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    int max = pq.poll();
                    sb.append(max).append("\n");
                }
            }
            else {
                pq.offer(n);
            }
        }

        System.out.println(sb.toString());
    }
}
