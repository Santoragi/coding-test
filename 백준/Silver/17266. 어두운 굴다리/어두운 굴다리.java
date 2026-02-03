import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] x;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        x = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int min = 1;
        int max = N;

        while(min < max) {
            int mid = (min + max) / 2;

            if(canInstall(mid)) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }

    static boolean canInstall(int height) {

        int min = x[0] - height;
        int max = x[0] + height;
        for(int i = 1; i < M; i++) {
            int lamp = x[i];
            int left = lamp - height;
            int right = lamp + height;
            if(left > max) return false;
            if(left < min) {
                min = left;
            }
            if(right > max) {
                max = right;
            }
        }

        return min <= 0 && max >= N;
    }
}