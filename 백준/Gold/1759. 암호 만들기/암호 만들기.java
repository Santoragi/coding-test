import java.io.*;
import java.util.*;

public class Main {

    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static int L, C;
    static char[] arr;
    static char[] code;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int depth, int index) {
        if(depth == L) {
            if(verify()) {
                printCode();
            }

            return;
        }

        for(int i = index ; i < C; i++) {
            code[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }

    public static void printCode() {
        sb.append(code).append("\n");
    }

    public static boolean verify() {
        int cnt_vowels = 0;  //모음 개수
        int cnt_cons = 0;  //자음 개수

        for(char c : code) {
            if(c == vowels[0] ||
                    c == vowels[1] ||
                    c == vowels[2] ||
                    c == vowels[3] ||
                    c == vowels[4])
                cnt_vowels++;
            else cnt_cons++;
        }

        return cnt_vowels >= 1 && cnt_cons >= 2;
    }
}