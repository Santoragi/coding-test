import java.util.*;

class Solution {
    
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        int row = maps.length;
        int col = maps[0].length;
        
        boolean[][] visited = new boolean[row][col];
        
        return bfs(row, col, maps, visited);
    }
    
    static int bfs(int row, int col, int[][] maps, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];
            
            if(y == row - 1 && x == col - 1) {
                return cnt;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny >= row || ny < 0 || nx >= col || nx < 0) continue;
                if(visited[ny][nx]) continue;
                if(maps[ny][nx] != 1) continue;
                
                q.add(new int[]{ny, nx, cnt + 1});
                visited[ny][nx] = true;   
            }
        }
        
        return -1;
    }
}