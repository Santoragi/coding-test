import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] nums;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];
        selected = new boolean[N + 1];

        dfs(0, 0);

        System.out.println(sb.toString());
    }

    static void dfs(int cnt, int idx) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(selected[i]) continue;

            nums[idx] = i;
            selected[i] = true;
            dfs(cnt + 1, idx + 1);
            selected[i] = false;
        }
    }
}
