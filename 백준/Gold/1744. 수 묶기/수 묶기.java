import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(Math.abs(o1) - Math.abs(o2));
            }
        };
        PriorityQueue<Integer> plus = new PriorityQueue<>(comp);
        PriorityQueue<Integer> minus = new PriorityQueue<>(comp);

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0) {
                plus.offer(num);
            }else {
                minus.offer(num);
            }
        }

        int sum = 0;
        while(!plus.isEmpty()) {
            int x = plus.poll();
            if(plus.isEmpty()) {
                sum += x;
                break;
            }
            int y = plus.poll();
            if(x == 1 || y == 1) {
                sum += x + y;
            }else {
                sum += x * y;
            }
        }

        while(!minus.isEmpty()) {
            int x = minus.poll();
            if(minus.isEmpty()) {
                sum += x;
                break;
            }
            int y = minus.poll();
            sum += x * y;
        }

        System.out.println(sum);
    }
}