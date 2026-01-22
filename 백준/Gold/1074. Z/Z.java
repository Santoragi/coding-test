import java.io.*;
import java.util.*;

public class Main {

    static int cnt = 0;
    static int[] dx = {0, 1, 0, 1};
    static int[] dy = {0, 0, 1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); //y
        int c = Integer.parseInt(st.nextToken()); //x
        int size = (int) Math.pow(2, N);

        visit(size, r, c);
        System.out.println(cnt);
    }

    static void visit(int size, int r, int c) {
        if(size == 1) return;

        if(r < size/2 && c < size/2) {         //1
            visit(size/2, r, c);
        }else if(r < size/2 && c >= size/2) {    //2
            cnt += (size * size / 4);
            visit(size/2, r, c - size/2);
        }else if(r >= size/2 && c < size/2) {   //3
            cnt += (size * size / 4) * 2;
            visit(size/2, r - size/2, c);
        }else if(r >= size/2 && c >= size/2) {   //4
            cnt += (size * size / 4) * 3;
            visit(size/2, r - size/2, c - size/2);
        }
    }
}