import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N + 1][3];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rgb[i][0] = r;
            rgb[i][1] = g;
            rgb[i][2] = b;
        }

        //i번째 집의 j색상 칠할때까지의 최소비용
        int[][] dp = new int[N + 1][3];
        dp[1][0] = rgb[1][0];
        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];

        for(int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + rgb[i][0], dp[i - 1][2] + rgb[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + rgb[i][1], dp[i - 1][2] + rgb[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + rgb[i][2], dp[i - 1][1] + rgb[i][2]);
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}

