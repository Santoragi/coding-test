import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(oper.equals("I")) {
                min_pq.add(num);
                max_pq.add(num);
            }
            else {
                if(max_pq.isEmpty() && min_pq.isEmpty()) continue;
                if(num == 1) {
                    //최댓값
                    int max = max_pq.poll();
                    min_pq.remove(max);
                }
                else {
                    //최솟값
                    int min = min_pq.poll();
                    max_pq.remove(min);
                }
            }
        }
        
        int[] result = {0, 0};
        if(!max_pq.isEmpty() && !min_pq.isEmpty()) {
            result[0] = max_pq.poll();
            result[1] = min_pq.poll();
        }
        
        return result;
    }
}