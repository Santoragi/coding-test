import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static String num;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = br.readLine();
        
        Deque<Integer> deq = new ArrayDeque<>();

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            int cur = Character.getNumericValue(num.charAt(i));

            while(!deq.isEmpty() && cur > deq.peek() && cnt < K) {
                deq.pop();
                cnt++;
            }

            if(deq.size() < N - K) {
                deq.push(cur);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deq.isEmpty()) {
            sb.append(deq.pollLast());
        }
        System.out.println(sb);
    }
}
