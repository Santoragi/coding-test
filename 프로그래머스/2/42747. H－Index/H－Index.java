import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int maxH = 0;
        for(int h = 0; h <= citations.length; h++) {
            int cnt = 0;
            for(int i = 0; i < citations.length; i++) {
                int citation = citations[i];
                if(citation >= h) cnt++;
            }
            
            if(cnt >= h && h >= maxH) {
                maxH = h;
            }
        }
        
        return maxH;
    }
}