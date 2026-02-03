import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] bug;
    static int[][] size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        bug = new int[M][M];
        for(int i = 0; i < M; i++) {
            Arrays.fill(bug[i], 1);
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            for(int j = M - 1; j > 0; j--) {
                if(zero != 0) {
                    zero--;
                }
                else if(one != 0) {
                    one--;
                    bug[j][0] += 1;
                }
                else if(two != 0) {
                    two--;
                    bug[j][0] += 2;
                }
            }

            for(int j = 0; j < M; j++) {
                if(zero != 0) {
                    zero--;
                }
                else if(one != 0) {
                    one--;
                    bug[0][j] += 1;
                }
                else if(two != 0) {
                    two--;
                    bug[0][j] += 2;
                }
            }

            for(int j = 1; j < M; j++) {
                for(int k = 1; k < M; k++) {
                    bug[j][k] = Math.max(bug[j][k-1], Math.max(bug[j - 1][k - 1], bug[j - 1][k]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(bug[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}