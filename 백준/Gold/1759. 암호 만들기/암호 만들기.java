import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] arr = {'a', 'e', 'i', 'o', 'u'};
    static char[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[C];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        String code = "";
        dfs(code, 0);

        System.out.println(sb.toString());
    }

    static void dfs(String code, int idx) {
        if(idx >= C) {
            if(verify(code)){
                sb.append(code).append("\n");
            }

            return;
        }

        String newCode = code + input[idx];
        dfs(newCode,idx + 1);
        dfs(code, idx + 1); //선택하지 않은 경우
    }

    static boolean verify(String code) {
        if(code.length() != L) return false;

        int cnt = 0;
        for(int i = 0; i < code.length(); i++) {
            for(char c : arr) {
                if(code.charAt(i) == c) cnt++;
            }
        }

        if(cnt >= 1 && code.length() - cnt >= 2) return true;
        else return false;
    }
}
