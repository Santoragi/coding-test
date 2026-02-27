import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        boolean[] visited = new boolean[n + 1];
        
        return bfs(graph, n, visited);
    }
    
    static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;
        
        int cnt = 0;
        int max = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];
            
            if(depth == max) {
                cnt++;
            }else if(depth > max) {
                cnt = 1;
                max = depth;
            }
            
            for(int next : graph.get(node)) {
                if(visited[next]) continue;
                
                visited[next] = true;
                q.add(new int[]{next, depth + 1});
            }
        }
        
        return cnt;
    }
}