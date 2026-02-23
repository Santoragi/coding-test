import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] schedule;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        schedule = new int[N + 1][2];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            calc(i, schedule[i][1]);
        }

        System.out.println(answer);
    }

    static void calc(int day, int pay) {
        if(day > N) return;
        int next = day + schedule[day][0];
        if(next > N + 1) return;

        if(pay > answer) {
            answer = pay;
        }

        for(int i = next; i <= N; i++) {
            calc(i, pay + schedule[i][1]);
        }
    }

}
