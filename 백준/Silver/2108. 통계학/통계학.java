import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            sum += n;
            pq.add(n);
            map.put(n, map.getOrDefault(n, 0) + 1);

            if(n > max) {
                max = n;
            }

            if(n < min) {
                min = n;
            }
        }


        //산술평균
        sb.append(Math.round(sum / N)).append("\n");

        //중앙값
        int mid = 0;
        for(int i = 0; i <= N / 2; i++) {
            mid = pq.poll();
        }
        sb.append(mid).append("\n");

        //최빈값
        PriorityQueue<Integer> count_que = new PriorityQueue<>();
        int cnt = 0;
        for(int n : map.keySet()) {
            if(map.get(n) > cnt) {
                cnt = map.get(n);
            }
        }

        for(int n : map.keySet()) {
            if(map.get(n) == cnt) {
                count_que.add(n);
            }
        }

        if(count_que.size() > 1) {
            count_que.poll();
            sb.append(count_que.poll()).append("\n");
        }
        else {
            sb.append(count_que.poll()).append("\n");
        }

        //범위
        sb.append(max - min).append("\n");

        System.out.println(sb);

    }

}
