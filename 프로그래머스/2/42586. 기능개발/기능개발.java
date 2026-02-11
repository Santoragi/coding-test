import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] days = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0) {
                day++;
            }
            days[i] = day;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i = 0; i < days.length; i++) {
            deq.addLast(days[i]);
        }
        
        
        while(!deq.isEmpty()) {
            int first = deq.pollFirst();
            int cnt = 1;
            
            while(true) {
                if(deq.isEmpty()) {
                    list.add(cnt);
                    break;
                }
                
                int next = deq.peekFirst();
                if(first < next) {
                    list.add(cnt);
                    break;
                }
                else {
                    deq.pollFirst();
                    cnt++;
                }
            }
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}