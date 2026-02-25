import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int size = id_list.length;
        int[][] graph = new int[size][size];
        int[] count = new int[size];
        
        for(String r : report) {
            StringTokenizer st = new StringTokenizer(r, " ");
            String from = st.nextToken();
            String to = st.nextToken();
            
            int fromIdx = getIdx(id_list, from);
            int toIdx = getIdx(id_list, to);
            
            if(graph[fromIdx][toIdx] == 0) {
                count[toIdx]++;   
            }
            graph[fromIdx][toIdx] = 1;
        }
        
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(count[j] >= k && graph[i][j] == 1) {
                    result[i]++;
                }
            }
        }
        return result;
    }
    
    static int getIdx(String[] id_list, String id) {
        for(int i = 0; i < id_list.length; i++) {
            if(id.equals(id_list[i])) {
                return i;
            }
        }
        return -1;
    }
}