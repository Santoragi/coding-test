import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < size; i++) {
            int date = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) {
                date++;
            }
            q.offer(date);
        }
        
        Queue<Integer> result = new LinkedList<>();
        
        int prev = q.poll();
        int cnt = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if(cur <= prev) {
                cnt++;
            }
            else {
                result.offer(cnt);
                cnt = 1;
                prev = cur;
            }
            
            if(q.isEmpty()) {
                result.offer(cnt);
            }
        }
        
        int[] answer = new int[result.size()];
        int idx = 0;
        while(!result.isEmpty()) {
            answer[idx++] = result.poll();
        }
        
        return answer;
    }
}