import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Comparator<int[]> comp = new Comparator<>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return -(o1[1] - o2[1]);
                }
                return o1[0] - o2[0];
            }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int deadLine = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());
            pq.add(new int[]{deadLine, cup});
        }

        PriorityQueue<Integer> select = new PriorityQueue<>();

        while(!pq.isEmpty()) {
            int[] problem = pq.poll();
            int deadLine = problem[0];
            int cup = problem[1];

            if(select.size() < deadLine) {
                select.add(cup);
            }else {
               if(select.peek() < cup) {
                   select.poll();
                   select.add(cup);
               }
            }
        }

        long total = 0;
        for(Integer num : select) {
            total += num;
        }

        System.out.println(total);
    }
}