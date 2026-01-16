import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] DUCK = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {

        char[] arr = br.readLine().toCharArray();

        if(arr.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int remain = arr.length;
        int cnt = 0;

        while(remain != 0) {
            int[] temp = new int[5];
            int pt = 0;
            int idx = 0;
            boolean check = false;

            while(idx < arr.length) {
                if(arr[idx] == DUCK[pt]) {
                    temp[pt++] = idx;
                    if(pt == 5) {
                        check = true;
                        pt = 0;
                        remain -= 5;
                        for(int i = 0; i < 5; i++) {
                            arr[temp[i]] = '\0';
                        }
                    }
                }
                idx++;
            }

            if(check) cnt++;
            else break;
        }

        System.out.println(remain==0?cnt:-1);
    }
}