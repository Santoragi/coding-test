import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int row) {
        if(row == N) {
            cnt++;
            return;
        }

        for(int col = 0; col < N; col++) {
            arr[row] = col;

            if(isPossible(row)) {
                dfs(row + 1);
            }
        }



    }

    static boolean isPossible(int row) {

        for(int i = 0; i < row; i++) {
            if(arr[i] == arr[row]) return false;

            if(Math.abs(i - row) == Math.abs(arr[i] - arr[row])) return false;
        }

        return true;
    }



}