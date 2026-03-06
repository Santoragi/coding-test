import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        int n = words.length;
        visited = new boolean[n];
        
        return bfs(begin, target, words, visited);
    }
    
    public int bfs(String begin, String target, String[] words, boolean[] visited) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(begin, 0));
        
        while(!q.isEmpty()) {
            Info cur = q.poll();
            
            if(cur.word.equals(target)) {
                return cur.dist;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(visited[i]) continue;
                String word = words[i];
                int diff = 0;
                for(int j = 0; j < word.length(); j++) {
                    int c1 = cur.word.charAt(j);
                    int c2 = word.charAt(j);
                    
                    if(c1 != c2) diff++;
                }
                
                if(diff == 1) {
                    visited[i] = true;
                    q.add(new Info(word, cur.dist + 1));
                }
            }
        }
        
        return 0;
    }
    
    static class Info{
        String word;
        int dist;
        
        public Info(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
}