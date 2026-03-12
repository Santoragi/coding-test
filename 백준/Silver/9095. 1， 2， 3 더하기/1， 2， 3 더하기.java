import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            int N = Integer.parseInt(br.readLine());

            //idx값을 만들 수 있는 모든 조합의 개수
            int[] dp = new int[11];
            dp[1] = 1;  //1
            dp[2] = 2;  //1 + 1, 2
            dp[3] = 4;  //1 + 1 + 1, 1 + 2, 2 + 1, 3

            //4이상부터는 다음과 같은 규칙을 따른다.
            for(int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}