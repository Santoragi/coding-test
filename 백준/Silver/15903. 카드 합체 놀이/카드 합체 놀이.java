import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> cards = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            cards.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++) {
            long min = cards.poll();
            long min2 = cards.poll();

            cards.add(min + min2);
            cards.add(min + min2);
        }

        long sum = 0;
        for(long card: cards) {
            sum += card;
        }

        System.out.println(sum);
    }
}