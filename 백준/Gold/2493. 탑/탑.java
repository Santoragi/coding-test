import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        Stack<int[]> stack = new Stack<>();

        for(int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(new int[]{i, height});
            }
            else {
                while(true) {
                    int[] tower = stack.peek();
                    int tower_num = tower[0];
                    int tower_height = tower[1];

                    if (tower_height > height) {
                        sb.append(tower_num).append(" ");
                        stack.push(new int[]{i, height});
                        break;
                    } else {
                        stack.pop();
                    }

                    if(stack.isEmpty()) {
                        sb.append(0).append(" ");
                        stack.push(new int[]{i, height});
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}