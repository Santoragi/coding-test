import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static int[] house;
    static int[] router;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        long max = house[house.length - 1] - house[0];
        long min = 1;

        while(min <= max) {

            long mid = (max + min) / 2;

            if(countRouter(mid) >= C) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }

    static int countRouter (long distance) {

        int count = 1;
        int lastPos = 0;

        for(int i = 1; i < N; i++) {
            long dist = house[i] - house[lastPos];
            if(dist >= distance) {
                lastPos = i;
                count++;
            }
        }

        return count;
    }

}