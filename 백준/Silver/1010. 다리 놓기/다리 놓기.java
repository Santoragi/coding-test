import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            //M개 중에서 N개를 뽑는 경우의 수
            sb.append(combi(M, N)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int combi(int n, int r) {

        //이미 개수를 가지고 있는 조합 반환
        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        //0개 중에 0개, n개 중에 n개를 뽑는 경우는 1개
        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

        //조합 공식의 성질
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}

