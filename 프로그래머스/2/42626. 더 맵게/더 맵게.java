import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        
        while(!pq.isEmpty()) {
            int first = pq.poll();
            if(first >= K) {
                //가장 맵지 않은 음식이 K이상이면
                break;
            }
            if(pq.isEmpty()) {
                //마지막 음식이면
                return -1;
            }
            
            int second = pq.poll();
            
            int mixed = first + (second * 2);
            pq.offer(mixed);
            answer++;
        }
        
        
        return answer;
    }
}