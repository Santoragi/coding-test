import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            System.out.println(bfs(A, B));
        }

    }

    static String bfs(Integer A, Integer B) {
        Queue<Integer> num = new LinkedList<>();
        Queue<String> cmd = new LinkedList<>();
        num.add(A);
        cmd.add("");
        visited[A] = true;

        String result = "";
        while(!num.isEmpty()) {
            Integer cur = num.poll();
            String s = cmd.poll();

            if((cur - B) == 0) {
                result = s;
                break;
            }

            int newNum = D(cur);
            if(!visited[newNum]) {
                visited[newNum] = true;
                num.add(newNum);
                cmd.add(s + "D");
            }
            newNum = S(cur);
            if(!visited[newNum]) {
                visited[newNum] = true;
                num.add(newNum);
                cmd.add(s+"S");
            }
            newNum = L(cur);
            if(!visited[newNum]) {
                visited[newNum] = true;
                num.add(newNum);
                cmd.add(s+"L");
            }
            newNum = R(cur);
            if(!visited[newNum]) {
                visited[newNum] = true;
                num.add(newNum);
                cmd.add(s+"R");
            }
        }

        return result;
    }

    static int D(int n) {
        return (n * 2) % 10000;
    }

    static int S(int n) {
        return  n != 0 ? n - 1 : 9999;
    }

    static int L(int n) {
        int d1 = n / 1000;
        int d2 = (n % 1000) / 100;
        int d3 = ((n % 1000) % 100) / 10;
        int d4 = ((n % 1000) % 100) % 10;

        return ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
    }

    static int R(int n) {
        int d1 = n / 1000;
        int d2 = (n % 1000) / 100;
        int d3 = ((n % 1000) % 100) / 10;
        int d4 = ((n % 1000) % 100) % 10;

        return ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
    }
}