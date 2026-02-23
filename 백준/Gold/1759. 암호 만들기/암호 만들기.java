import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] arr = {'a', 'e', 'i', 'o', 'u'};
    static char[] input;
    static char[] code;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        dfs(0, 0);

        System.out.println(sb.toString());
    }

    //뽑는 개수가 정해져있으니 조합 생성 방식 사용
    static void dfs(int cnt, int idx) {
        if(cnt == L) {
            if(verify()) {
                sb.append(code).append("\n");
            }
            return;
        }

        for(int i = idx; i < C; i++) {
            code[cnt] = input[i];
            dfs(cnt + 1, i + 1);
        }
    }

    static boolean verify() {
        int cnt1 = 0;
        int cnt2 = 0;

        for(char c : code) {
            if(c == arr[0] || c == arr[1] || c == arr[2] || c == arr[3] || c == arr[4]) cnt1++;
            else cnt2++;
        }

        if(cnt1 >= 1 && cnt2 >= 2) return true;
        else return false;
    }
}
