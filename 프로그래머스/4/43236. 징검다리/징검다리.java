import java.util.*;

class Solution {
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;
        
        //이분 탐색
        int left = 1;
        int right = distance;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(getRemoveCount(distance, mid, rocks) <= n) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static int getRemoveCount(int distance, int mid, int[] rocks) {
        
        int prev = 0;
        int end = distance;
        
        int removeCount = 0;
        for(int i = 0; i < rocks.length; i++) {
            if(rocks[i] - prev < mid) {
                removeCount++;
                continue;
            }
            
            prev = rocks[i];
        }
        
        if(end - prev < mid) removeCount++;
        
        return removeCount;
    }
}