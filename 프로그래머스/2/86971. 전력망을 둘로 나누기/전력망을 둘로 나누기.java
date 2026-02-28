import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {    
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        int min = Integer.MAX_VALUE;
        for(int[] wire : wires) {
            int cnt1 = bfs(n, wire[0], wire[1]);
            int cnt2 = bfs(n, wire[1], wire[0]);
            
            int diff = Math.abs(cnt1 - cnt2);
            if(diff < min) {
                min = diff;
            }
        }
        
        return min;
    }
    
    static int bfs(int n, int start, int cut) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        visited = new boolean[n + 1];
        visited[start] = true;
        
        int cnt = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int next : graph.get(node)) {
                if(visited[next]) continue;
                if(next == cut) continue;
                
                visited[next] = true;
                q.add(next);
                cnt++;
            }
        }
        
        return cnt;
    }
}