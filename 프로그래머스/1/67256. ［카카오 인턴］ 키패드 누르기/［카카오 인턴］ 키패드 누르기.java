import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        int[] left_pos = {3, 0};
        int[] right_pos = {3, 2};
        
        StringBuilder sb = new StringBuilder();
        
        //n - 1을
        //3으로 나눈 나머지가 x좌표
        //3으로 나눈 몫이 y좌표?
        for(int n : numbers) {
            int y, x;
            if(n == 0) {
                y = 3;
                x = 1;
            }
            else {
                y = (n - 1) / 3;
                x = (n - 1) % 3;
            }
            
            if(x == 0) {
                sb.append("L");
                left_pos[0] = y;
                left_pos[1] = x;
                continue;
            }
            else if(x == 2) {
                sb.append("R");
                right_pos[0] = y;
                right_pos[1] = x;
                continue;
            }
            
            
            int left_dist = Math.abs(left_pos[0] - y) + Math.abs(left_pos[1] - x);
            int right_dist = Math.abs(right_pos[0] - y) + Math.abs(right_pos[1] - x);
            if(left_dist == right_dist) {
                if(hand.equals("right")) {
                    sb.append("R");
                    right_pos[0] = y;
                    right_pos[1] = x;
                }
                else {
                    sb.append("L");
                    left_pos[0] = y;
                    left_pos[1] = x;
                }
            }
            else if(left_dist > right_dist) {
                sb.append("R");
                right_pos[0] = y;
                right_pos[1] = x;
            }
            else {
                sb.append("L");
                left_pos[0] = y;
                left_pos[1] = x;
            }
        }
        
        return sb.toString();
    }
}