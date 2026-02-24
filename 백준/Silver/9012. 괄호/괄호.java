import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static String yes = "YES";
    static String no = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c == '(') {
                    stack.push(c);
                }
                else {
                    if(stack.isEmpty()) {
                        isVPS = false;
                        continue;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) isVPS = false;

            if(isVPS) {
                sb.append(yes).append("\n");
            }
            else {
                sb.append(no).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
