import java.io.*;

public class Main {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);

        System.out.println(count);
        System.out.println(sb);
    }

    //하노이탑 - 재귀
    //hanoi(3, 1, 3, 2) => hanoi(2, 1, 2, 3), 1 -> 3, hanoi(2, 2, 3, 1)
    //hanoi(2, 1, 3, 2) => hanoi(1, 1, 2, 3), 1 -> 3, hanoi(1, 2, 3, 1)
    //hanoi(n, start, end, mid) => hanoi(n - 1, start, mid, end), start -> end, hanoi(n - 1, mid, end, start)
    //1. start의 가장 밑 원판을 제외하고 n - 1개를 mid로 이동하는 hanoi 호출
    //2. 가장 밑 원판을 end로 이동
    //3. mid의 n - 1개의 원판을 end 이동하는 hanoi 호출
    //n이 1인 경우 start -> end 이동 후 종료
    public static void hanoi(int n, int start, int end, int mid) {
        count++;
        
        if(n == 1) {
            printMoveInfo(start, end);
            return;
        }

        hanoi(n - 1, start, mid, end);
        printMoveInfo(start, end);
        hanoi(n - 1, mid, end, start);
    }

    public static void printMoveInfo(int start, int end) {
        sb.append(start).append(" ").append(end).append("\n");
    }
}