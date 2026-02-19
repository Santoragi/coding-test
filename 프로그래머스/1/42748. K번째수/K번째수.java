import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] result = new int[commands.length];
        
        int idx = 0;
        for(int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            int[] arr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(arr);
            result[idx] = arr[k - 1];
            idx++;
        }
        
        return result;
    }
}