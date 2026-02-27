import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> routes = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(routes);
        String best = routes.get(0);
        
        String[] answer = best.split(" ");
        
        return answer;
    }
    
    static void dfs(String start, String route, String[][] tickets, int cnt) {
        if(cnt == tickets.length) {
            routes.add(route);
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(start.equals(tickets[i][0]) &&
              !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
        
    }
}