import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] W;
    static int[] V;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];
        dp = new Integer[N][K + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int result = topdown(N - 1, K);
        System.out.println(result);
    }

    static int topdown(int i, int k) {
        if(i < 0) {
            return 0;
        }

        if(dp[i][k] == null) {

            if(W[i] > k) {
                dp[i][k] = topdown(i - 1, k);
            }
            else {
                dp[i][k] = Math.max(topdown(i - 1, k), topdown(i - 1, k - W[i]) + V[i]);
            }
        }

        return dp[i][k];
    }
}