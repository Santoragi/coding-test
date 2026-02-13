import java.io.*;
import java.util.*;

public class Main {

    static int TEST_CASE;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TEST_CASE = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(TEST_CASE --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[] priorities = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(solution(priorities, M)).append("\n");
        }

        System.out.println(sb);
    }

    static int solution(int[] priorities, int location) {

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            q.add(new int[]{priorities[i], i});
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            boolean isFirst = true;

            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] next = q.poll();

                if(cur[0] < next[0]) {
                    isFirst = false;
                }

                q.add(next);
            }

            if(isFirst) {
                cnt++;
                if(cur[1] == location) {
                    return cnt;
                }
            }
            else {
                q.add(cur);
            }
        }

        return cnt;
    }

}
