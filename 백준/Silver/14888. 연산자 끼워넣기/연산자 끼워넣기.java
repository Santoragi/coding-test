import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] operators; // +, -, *, / 순서
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        operators = new int[4];

        Deque<Integer> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            dq.offerLast(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        calc(dq, operators);
        System.out.println(max);
        System.out.println(min);
    }

    static void calc(Deque<Integer> nums, int[] operators) {
        if(nums.size() == 1) {
            int n = nums.poll();
            if(n > max) max = n;
            if(n < min) min = n;

            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] != 0) {
                int n1 = nums.pollFirst();
                int n2 = nums.pollFirst();

                int result;
                switch(i) {
                    case 0: result = n1 + n2;
                    break;

                    case 1: result = n1 - n2;
                    break;

                    case 2: result = n1 * n2;
                    break;

                    case 3: result = n1 / n2;
                    break;

                    default: result = 0;
                }
                nums.addFirst(result);
                operators[i]--;

                calc(nums, operators);

                operators[i]++;
                nums.pollFirst();
                nums.addFirst(n2);
                nums.addFirst(n1);
            }
        }
    }
}
