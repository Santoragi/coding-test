import java.util.*;

class Solution {
    
    static int N;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        
        List<List<int[]>> emptySpace = new ArrayList<>();
        List<List<int[]>> puzzle = new ArrayList<>();
        
        N = game_board.length;
        
        boolean[][] visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]) {
                    emptySpace.add(findEmptySpace(i, j, game_board, visited));
                }
            }
        }
        
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(table[i][j] == 1 && !visited[i][j]) {
                    puzzle.add(findPuzzle(i, j, table, visited));
                }
            }
        }
        
        int cnt = match(emptySpace, puzzle);
        
        return cnt;
    }
    
    public static List<int[]> findEmptySpace(int y, int x,
                                             int[][] board, boolean[][] visited) {
        
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{y, x});
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
                if(board[ny][nx] != 0) continue;
                if(visited[ny][nx]) continue;
                
                q.add(new int[]{ny, nx});
                visited[ny][nx] = true;
                
                result.add(new int[]{ny, nx});
            }
        }
        
        return normalize(result);
    }
    
    public static List<int[]> findPuzzle(int y, int x,
                                             int[][] board, boolean[][] visited) {
        
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{y, x});
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
                if(board[ny][nx] != 1) continue;
                if(visited[ny][nx]) continue;
                
                q.add(new int[]{ny, nx});
                visited[ny][nx] = true;
                
                result.add(new int[]{ny, nx});
            }
        }
        
        return normalize(result);
    }
    
    //정규화
    public static List<int[]> normalize(List<int[]> positions) {
        
        List<int[]> result = new ArrayList<>();
        
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        
        for(int[] pos : positions) {
            if(pos[0] < minY) {
                minY = pos[0];
            }
            
            if(pos[1] < minX) {
                minX = pos[1];
            }
        }
        
        for(int[] pos : positions) {
            result.add(new int[]{pos[0] - minY, pos[1] - minX});
        }
        
        return result;  
    }
    
    
    //빈 공간과 블록 매치
    public static int match(List<List<int[]>> emptySpace,
                                List<List<int[]>> puzzle) {
        
        int result = 0;
        
        boolean[] selected = new boolean[puzzle.size()];
        for(int i = 0; i < emptySpace.size(); i++) {
            List<int[]> empty = emptySpace.get(i);
            
            for(int j = 0; j < puzzle.size(); j++) {
                if(selected[j]) continue;
                
                List<int[]> p = puzzle.get(j);
                if(rotateAndCompare(empty, p)) {
                    result += p.size();
                    selected[j] = true;
                    break;
                }
            }
        }
        
        return result;
    }
    
    public static boolean rotateAndCompare(List<int[]> empty, List<int[]> puzzle) {
        //칸 개수 확인
        if(empty.size() != puzzle.size()) return false;
        
        List<int[]> rotated = puzzle;
        for(int i = 0; i < 4; i++) {
            if(compare(empty, rotated)) {
                return true;
            }
            
            rotated = rotate(rotated);
        }
        
        return false;
    }
    

    public static List<int[]> rotate(List<int[]> positions) {
        
        List<int[]> result = new ArrayList<>();
        
        for(int[] p : positions) {
            int y = p[1];
            int x = -p[0];
            
            result.add(new int[]{y, x});
        }
        
        return normalize(result);
    }
    
    public static boolean compare(List<int[]> empty, List<int[]> puzzle) {
        // y좌표 우선 오름차순, x좌표 오름차순 정렬 
        Comparator<int[]> comp = new Comparator<>(){
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                
                return o1[0] - o2[0];
            }
        };
        
        Collections.sort(empty, comp);
        Collections.sort(puzzle, comp);
        
        for(int i = 0; i < empty.size(); i++) {
            int[] e = empty.get(i);
            int[] p = puzzle.get(i);
            
            if(e[0] != p[0] || e[1] != p[1]) {
                return false;
            }
        }
        
        return true;
    }
}
