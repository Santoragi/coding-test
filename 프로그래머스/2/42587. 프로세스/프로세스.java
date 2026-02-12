import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new int[]{priorities[i], i});
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            boolean isFirst = true;
            
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] next = q.poll();
                if(cur[0] < next[0]) {
                    isFirst = false;
                }
                q.add(next);
            }
            
            if(isFirst) {
                cnt++;
                if(cur[1] == location) {
                    break;
                }
            }
            else {
                q.add(cur);
            }
        }
        
        return cnt;
    }
}