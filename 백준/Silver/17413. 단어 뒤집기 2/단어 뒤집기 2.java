import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringBuilder sb = new StringBuilder();

        Deque<String> deq = new ArrayDeque<>();
        boolean tag = false;
        for(int i = 0; i < line.length(); i++) {
            String c = String.valueOf(line.charAt(i));

            if(c.equals("<")) {
                tag = true;
                while(!deq.isEmpty()) {
                    sb.append(deq.pollLast());
                }
                deq.addLast(c);
                continue;
            }
            else if(c.equals(">")) {
                tag = false;
                deq.addLast(c);
                while(!deq.isEmpty()) {
                    sb.append(deq.pollFirst());
                }
                continue;
            }

            if(tag) {
                deq.addLast(c);
            }
            else {
                if(!c.equals(" ")) {
                    deq.addLast(c);
                }
                else {
                    while(!deq.isEmpty()) {
                        sb.append(deq.pollLast());
                    }
                    sb.append(" ");
                }
            }
        }

        while(!deq.isEmpty()) {
            sb.append(deq.pollLast());
        }

        System.out.println(sb.toString());
    }

}
