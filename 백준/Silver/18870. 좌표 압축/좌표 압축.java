import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] sorted;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        sorted = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            nums[i] = n;
            sorted[i] = n;
        }

        Arrays.sort(sorted);

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(sorted[i])) {
                map.put(sorted[i], cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(map.get(nums[i])).append(" ");
        }

        System.out.println(sb.toString());
    }
}
