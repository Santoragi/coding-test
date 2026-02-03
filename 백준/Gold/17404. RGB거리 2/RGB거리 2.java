import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] cost;
    static int MAX_VALUE = 10000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = MAX_VALUE;

        for(int first = 0; first < 3; first++) {
            int[][] dp = new int[N][3];

            for(int i = 0; i < 3; i++) {
                dp[0][i] = MAX_VALUE;
            }
            dp[0][first] = cost[0][first];

            for(int i = 1; i < N; i++) {
                dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            for(int last = 0; last < 3; last++) {
                if(first == last) continue;
                result = Math.min(result, dp[N - 1][last]);
            }
        }

        System.out.println(result);
    }
}
