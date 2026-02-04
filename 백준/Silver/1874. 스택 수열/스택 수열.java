import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 1;
        for(int i = 0; i < N; i++) {
            int target = nums[i];

            if(stack.search(target) == -1) {
                for(int j = n; j <= target; j++) {
                    stack.push(j);
                    n++;
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            }
            else if(stack.search(target) == 1){
                stack.pop();
                sb.append("-").append("\n");
            }
            else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}