import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //dp 풀이 연습
        //idx에 해당하는 수까지 도착할 수 있는 연산 횟수의 최솟값 저장
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;

        int n = N;
        while(n != 1) {
            if(n % 2 == 0) {
                dp[n / 2] = Math.min(dp[n / 2], dp[n] + 1);
            }
            if(n % 3 == 0) {
                dp[n / 3] = Math.min(dp[n / 3], dp[n] + 1);
            }

            dp[n - 1] = Math.min(dp[n - 1], dp[n] + 1);

            n = n - 1;
        }

        System.out.println(dp[1]);
    }
}