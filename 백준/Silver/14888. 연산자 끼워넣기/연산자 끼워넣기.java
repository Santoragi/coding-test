import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] operators = new int[4]; // +, -, *, / 순서
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        calc(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void calc(int num, int idx) {
        if(idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i]--;
                switch(i) {
                    case 0: calc(num + nums[idx], idx + 1); break;
                    case 1: calc(num - nums[idx], idx + 1); break;
                    case 2: calc(num * nums[idx], idx + 1); break;
                    case 3: calc(num / nums[idx], idx + 1); break;
                }
                operators[i]++;
            }
        }
    }
}
