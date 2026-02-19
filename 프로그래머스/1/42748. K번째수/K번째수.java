import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            int[] arr = new int[end - start + 1];
            int idx = 0;
            for(int j = start; j <= end; j++) {
                arr[idx] = array[j];
                idx++;
            }
            
            Arrays.sort(arr);
            result.add(arr[k]);
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}