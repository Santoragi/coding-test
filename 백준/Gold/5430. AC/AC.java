import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();

            if(n > 0) {
                s = s.substring(1, s.length() - 1);
                st = new StringTokenizer(s, ",");
                while(st.hasMoreTokens()) {
                    dq.add(Integer.parseInt(st.nextToken()));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for(int j = 0; j < p.length(); j++) {
                char c = p.charAt(j);

                if(c == 'R') {
                    reverse = !reverse;
                }
                else if(c == 'D') {
                    if(dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if(reverse) {
                        dq.pollLast();
                    }else {
                        dq.pollFirst();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if(error) {
                System.out.println("error");
            } else {
                sb.append("[");
                while(!dq.isEmpty()) {
                    if(reverse) {
                        sb.append(dq.pollLast());
                        if(dq.isEmpty()) break;
                        sb.append(",");
                    }
                    else {
                        sb.append(dq.pollFirst());
                        if(dq.isEmpty()) break;
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }

}