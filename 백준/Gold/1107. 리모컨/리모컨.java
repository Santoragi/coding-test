import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] broken = new boolean[10]; //0 ~ 9
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if(M > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        //1. 100인 경우
        if(N == 100) {
            System.out.println(0);
            System.exit(0);
        }

        //2. 100에서 +, - 버튼만 사용한 경우
        count = Math.abs(N - 100);

        //3. 근사치에서 +, - 버튼을 사용하는 경우
        dfs(0, 0);

        System.out.println(count);
    }

    //각 버튼을 누른뒤에 +, - 버튼을 사용하여 목표 채널로 이동할 때 누를 버튼 수와 기존 버튼 수의 크기를 비교
    static void dfs(int idx, int channel) {
        for(int i = 0; i < 10; i++) {
            if(!broken[i]) {
                int newChannel = channel * 10 + i;
                //목표 채널과 새로운 채널의 차이만큼 + 현재 채널까지 오기위한 버튼 수
                int cnt = Math.abs(N - newChannel) + String.valueOf(newChannel).length();
                count = Math.min(count, cnt);

                //N은 500,000이하이므로
                //현재 자리수가 6이하이면 다음 버튼
                if(idx < 6) {
                    dfs(idx + 1, newChannel);
                }
            }
        }
    }
}
