import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] eggs;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            eggs[i][0] = d;
            eggs[i][1] = w;
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int idx) {
        if(idx == N) {
            max = Math.max(count_egg(), max);
            return;
        }

        if(eggs[idx][0] <= 0) {
            dfs(idx + 1);
        }
        else {
            boolean hit = false;
            for(int i = 0; i < N; i++) {
                if(i == idx) continue;
                if(eggs[i][0] <= 0) continue;

                hit = true;
                eggs[idx][0] -= eggs[i][1];
                eggs[i][0] -= eggs[idx][1];
                dfs(idx + 1);
                eggs[idx][0] += eggs[i][1];
                eggs[i][0] += eggs[idx][1];
            }

            if(!hit) dfs(idx + 1);
        }
    }

    static int count_egg() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(eggs[i][0] <= 0) cnt++;
        }
        return cnt;
    }


}