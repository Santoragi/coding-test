import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(!pq.isEmpty()) {
            int first = pq.poll();
            if(first >= K) break;
            if(pq.isEmpty()) {
                return -1;
            }
            int second = pq.poll();
            
            //mix
            int mix = first + second * 2;
            cnt++;
            pq.add(mix);
        }
        
        return cnt;
    }
}