import java.io.*;
import java.util.*;

public class Main {

    static int N, r, c;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        z(N, r, c);
        System.out.println(cnt);
    }

    public static void z(int n, int r, int c) {
        if(n == 0) return;

        int size = (int) (Math.pow(2, n - 1));
        if(r < size && c < size) {         //1
            z(n - 1, r, c);
        }else if(r < size && c >= size) {    //2
            cnt += size * size;
            z(n - 1, r, c - size);
        }else if(r >= size && c < size) {   //3
            cnt += size * size * 2;
            z(n - 1, r - size, c);
        }else if(r >= size && c >= size) {   //4
            cnt += size * size * 3;
            z(n - 1, r - size, c - size);
        }
    }
}