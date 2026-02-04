import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        Stack<Character> left_stack = new Stack<>();
        Stack<Character> right_stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            left_stack.push(s.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            char cmd = st.nextToken().charAt(0);
            if (cmd == 'L') {
                if(!left_stack.isEmpty()) {
                    char c = left_stack.pop();
                    right_stack.push(c);
                }
            } else if (cmd == 'D') {
                if(!right_stack.isEmpty()) {
                    char c = right_stack.pop();
                    left_stack.push(c);
                }
            } else if (cmd == 'B') {
                if(!left_stack.isEmpty()) {
                    left_stack.pop();
                }
            } else if (cmd == 'P') {
                char c = st.nextToken().charAt(0);
                left_stack.push(c);
            }
        }

        while(!left_stack.isEmpty()) {
            right_stack.push(left_stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!right_stack.isEmpty()) {
            sb.append(right_stack.pop());
        }

        System.out.println(sb);
    }
}