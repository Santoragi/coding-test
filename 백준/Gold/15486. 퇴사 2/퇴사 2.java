import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] jobs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        jobs = new int[N + 1][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken());
            jobs[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        int max = 0;
        for(int i = 0; i <= N; i++) {
            max = Math.max(max, dp[i]);

            int next = i + jobs[i][0];
            if(next >= N + 1) continue;

            dp[next] = Math.max(dp[next], max + jobs[i][1]);
        }

        System.out.println(dp[N]);
    }
}