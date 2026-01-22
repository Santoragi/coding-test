import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[] heart = new int[2];
        boolean isHeart = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '*') {
                    heart = new int[]{i + 1, j};
                    isHeart = true;
                    break;
                }
            }
            if(isHeart) break;
        }
        System.out.println((heart[0] + 1) + " " + (heart[1] + 1)); //심장

        int left_arm_length = 0;
        int right_arm_length = 0;
        int x = heart[1] - 1;
        while(board[heart[0]][x] == '*' || x >= n || x < 0) {
            left_arm_length++;
            x--;
            if(x < 0) break;
        }

        x = heart[1] + 1;
        while(board[heart[0]][x] == '*' || x >= n || x < 0) {
            right_arm_length++;
            x++;
            if(x >= n) break;
        }

        int y = heart[0] + 1;
        int waist_length = 0;
        int left_lag_length = 0;
        int right_lag_length = 0;

        while(board[y][heart[1]] == '*' || y >= n || y < 0) {
            waist_length++;
            y++;
            if(y >= n) break;
        }

        int newY = heart[0] + waist_length + 1;
        while(board[newY][heart[1] - 1] == '*') {
            left_lag_length++;
            newY++;
            if(newY >= n) break;
        }

        newY = heart[0] + waist_length + 1;
        while(board[newY][heart[1] + 1] == '*') {
            right_lag_length++;
            newY++;
            if(newY >= n) break;
        }

        System.out.println(left_arm_length + " " + right_arm_length + " " + waist_length + " " + left_lag_length + " " + right_lag_length);
    }
}