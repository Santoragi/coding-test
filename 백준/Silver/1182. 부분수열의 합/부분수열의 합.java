import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static int[] nums;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(cnt);
    }

    static void dfs(int sum, int idx) {
        if(idx == N) return;

        for(int i = idx; i < N; i++) {
            if(sum + nums[i] == S) cnt++;
            dfs(sum + nums[i], i + 1);
        }
    }
}
