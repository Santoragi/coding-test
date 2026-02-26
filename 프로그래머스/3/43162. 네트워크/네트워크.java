class Solution {
    static boolean[] visited;
    static int N;
    static int[][] graph;
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        visited = new boolean[n];
        graph = computers;
        N = n;
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            dfs(i, 1);
            cnt++;
        }
        
        return cnt;
    }
    
    static void dfs(int node, int depth) {
        if(depth >= N) {
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(node == i) continue;
            if(visited[i]) continue;
            if(graph[node][i] != 1) continue;
            
            visited[i] = true;
            dfs(i, depth + 1);
        }
    }
}