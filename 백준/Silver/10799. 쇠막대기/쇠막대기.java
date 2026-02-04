import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else if(s.charAt(i) == ')') {
                int start = stack.pop();
                if(i - start != 1) {
                    // 막대인 경우
                    total++;
                }
                else {
                    // 레이저인 경우
                    total += stack.size();
                }
            }
        }

        System.out.println(total);
    }
}