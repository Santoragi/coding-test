import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> left_stack = new Stack<>();
        Stack<Integer> right_stack = new Stack<>();
        Stack<Integer> result_stack = new Stack<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            left_stack.push(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < N; i++) {
            int n = left_stack.pop();

            while(!right_stack.isEmpty()) {
                int m = right_stack.pop();
                if(n < m) {
                    result_stack.push(m);
                    right_stack.push(m);
                    right_stack.push(n);
                    break;
                }
            }

            if(right_stack.isEmpty()) {
                result_stack.push(-1);
                right_stack.push(n);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!result_stack.isEmpty()) {
            sb.append(result_stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}