import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        StringBuilder sb = new StringBuilder();

        //숫자 입력
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            //모든 숫자의 합
            sum += n;

            //누적 값 증가
            arr[n + 4000]++;

            //최댓값 갱신
            if(n > max) {
                max = n;
            }

            //최솟값 갱신
            if(n < min) {
                min = n;
            }
        }

        int cnt = 0; //누적 개수
        int mid = 0; //중앙값
        int max_cnt = 0; //최대 빈도 수
        boolean flag = false; //true: 최빈값이 여러 개, false: 최빈값이 한 개
        int second = 0; //최빈값(여러 개면 두번째 작은 값)

        //중앙값과 최빈값
        for(int i = min + 4000; i <= max + 4000; i++) {
            if(arr[i] <= 0) continue;

            //누적 개수가 N / 2보다 작다면 개수 누적, 중앙값 업데이트
            if (cnt < N / 2 + 1) {
                cnt += arr[i];
                if (cnt >= N / 2 + 1) mid = i - 4000;
            }

            //빈도수가 가장 많은 숫자를 발견
            if(arr[i] > max_cnt) {
                //처음에 한 개로 설정
                flag = false;
                max_cnt = arr[i];
                second = i - 4000;
            }
            //가장 많은 빈도수와 같은 숫자를 발견, 그 전까지 한 개만 발견된 상태이면
            else if(arr[i] == max_cnt && !flag) {
                //두 번째 최빈값을 저장
                flag = true;
                second = i - 4000;
            }
        }

        sb.append((int)Math.round((double)sum / N)).append("\n"); //산술평균
        sb.append(mid).append("\n");                 //중앙값
        sb.append(second).append("\n");              //최빈값
        sb.append(max - min).append("\n");           //범위

        System.out.println(sb);

    }

}
