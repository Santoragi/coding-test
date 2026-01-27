import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int a = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            if(cmd.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                a = a | (1 << x);
            }else if(cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                a &= ~(1 << x);
            }else if(cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append((a & (1 << x)) != 0 ? 1 : 0).append("\n");
            }else if(cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                a = a ^ (1 << x);
            }else if(cmd.equals("all")) {
                a = (1 << 21) - 1;
            }else if(cmd.equals("empty")) {
                a = 0;
            }
        }

        System.out.println(sb);
    }
}