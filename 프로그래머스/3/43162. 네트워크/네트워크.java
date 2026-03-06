import java.util.*;

class Solution {
    
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            bfs(i);
            cnt++;
        }
        
        return cnt;
    }
    
    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        visited[node] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : graph.get(cur)) {
                if(visited[next]) continue;
                
                visited[next] = true;
                q.add(next);
            }
        }
    }
}