import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] ACCOUNT = {25, 10, 5, 1};
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        int[] problem = new int[N];
        for(int i = 0; i < N; i++) {
            problem[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++) {
            solution(problem[i]);
            System.out.println();
        }

    }

    public static void solution(int pay) {
        int p = pay;
        for(int i = 0; i < 4; i++) {
            int cnt = 0;
            if(p / ACCOUNT[i] > 0) {
                cnt += p / ACCOUNT[i];
                p -= ACCOUNT[i] * (p / ACCOUNT[i]);
            }
            System.out.print(cnt + " ");
        }
    }
}