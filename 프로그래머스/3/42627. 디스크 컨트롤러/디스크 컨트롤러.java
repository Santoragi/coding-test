import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //jobs[i] : 요청 시각, 소요 시간
        
        //작업 소요 시간 짧은 순, 작업의 요청 시각이 빠른 순, 작업의 번호가 작은 순
        //0: 요청 시각, 1: 소요 시간
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {    
                    return o1[0] - o2[0];
                }
                
                return o1[1] - o2[1];
            }   
        });
        
        boolean[] visited = new boolean[jobs.length];
        
        int time = 0;
        int cnt = 0;
        int sum = 0;
        while(cnt < jobs.length) {
            for(int i = 0; i < jobs.length; i++) {
                if(jobs[i][0] <= time && !visited[i]) {
                    pq.add(jobs[i]);
                    visited[i] = true;
                }
            }
            
            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                cnt++;
                sum += time - job[0];
            }
            else {
                time++;
            }
        }
        return sum / jobs.length;
    }
}