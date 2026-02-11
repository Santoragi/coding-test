import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++) {
            if(deq.isEmpty()) {
                deq.addLast(arr[i]);
                continue;
            }
            
            int cur = deq.peekLast();
            if(arr[i] != cur) {
                deq.addLast(arr[i]);
            }
        }
        
        int[] answer = new int[deq.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = deq.pollFirst();
        }
        
        return answer;
    }
}