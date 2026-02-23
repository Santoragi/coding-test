import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] num;
    static boolean[] selected;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            selected = new boolean[N];
            selected[i] = true;
            dfs(0, num[i], 0);
        }
        System.out.println(max);
    }

    static void dfs(int sum, int prev, int depth) {
        if(depth == N - 1) {
            if(sum > max) {
                max = sum;
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!selected[i]) {
                selected[i] = true;
                dfs(sum + Math.abs(prev - num[i]), num[i], depth + 1);
                selected[i] = false;
            }
        }
    }
}
