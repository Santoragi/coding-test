import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> chicken = new ArrayList<>();
    static boolean[] selected;
    static List<int[]> house = new ArrayList<>();

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 2) {
                    chicken.add(new int[]{i, j});
                }
                else if(n == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(min);
    }

    static void dfs(int cnt, int idx) {
        if(cnt == M) {
            int dist = getDistance();
            if(dist < min) {
                min = dist;
            }
            return;
        }

        for(int i = idx; i < chicken.size(); i++) {
            selected[i] = true;
            dfs(cnt + 1, i + 1);
            selected[i] = false;
        }
    }

    //모든 집의 치킨거리 합
    static int getDistance() {
        int sum = 0;

        for(int[] h : house) {
            int min_dist = Integer.MAX_VALUE;
            for(int i = 0; i < chicken.size(); i++) {
                if(selected[i]) {
                    int[] c = chicken.get(i);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    if(dist < min_dist) {
                        min_dist = dist;
                    }
                }
            }

            sum += min_dist;
        }

        return sum;
    }
}
