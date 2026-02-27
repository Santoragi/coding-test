import java.util.*;

class Solution {
    
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int N;
    
    public int solution(String begin, String target, String[] words) {
        N = words.length;
        visited = new boolean[N];
        
        boolean possible = false;
        for(String w : words) {
            if(w.equals(target)) {
                possible = true;
                break;
            }
        }
        
        if(possible) {
            bfs(begin, target, words);
        }
        else {
            return 0;
        }
        return min;
    }
    
    static void bfs(String begin, String target, String[] words) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(begin, 0));
        
        while(!q.isEmpty()) {
            Info cur = q.poll();
            
            if(cur.word.equals(target)) {
                min = cur.depth;
                break;
            }
            
            for(int i = 0; i < N; i++) {
                String word = words[i];
                
                if(visited[i]) continue;
                
                int cnt = 0;
                for(int j = 0; j < word.length(); j++) {
                    char c1 = cur.word.charAt(j);
                    char c2 = word.charAt(j);
                    
                    if(c1 != c2) cnt++;
                }
                
                if(cnt == 1) {
                    visited[i] = true;
                    q.add(new Info(word, cur.depth + 1));
                }
            }
        }     
    }
    
    static class Info {
        String word;
        int depth;
        
        public Info(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}