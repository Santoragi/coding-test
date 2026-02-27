import java.util.*;

class Solution {
    static int N, M;
    public int solution(int[][] board, int[] moves) {
        N = board.length;
        M = board[0].length;
        
        Stack<Integer> basket = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        
        int cnt = 0;
        for(int m : moves) {
            int x = m - 1;
            int y = getY(board, x);
            if(y == N) continue;
            
            int doll = board[y][x];
            
            board[y][x] = 0;
            basket.push(doll);
        }
        
        while(!basket.isEmpty()) {
            int cur = basket.pop();
            if(basket.isEmpty()) continue;
            
            int next = basket.peek();
            if(cur == next) {
                basket.pop();
                cnt += 2;
                while(!temp.isEmpty()) {
                    basket.push(temp.pop());
                }
            }
            else {
                temp.push(cur);
            }
        }
        
        return cnt;
    }
    
    //x좌표에서 가장 위에 있는 인형의 y좌표
    static int getY(int[][] board, int x) {
        int y = N;
        for(int i = 0; i < N; i++) {
            if(board[i][x] != 0) {
                y = i;
                break;
            }
        }
        
        return y;
    }
}