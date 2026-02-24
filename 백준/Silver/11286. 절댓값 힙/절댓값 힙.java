import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    int min = pq.poll();
                    sb.append(min).append("\n");
                }
            }
            else {
                pq.offer(n);
            }
        }

        System.out.println(sb.toString());
    }
}
