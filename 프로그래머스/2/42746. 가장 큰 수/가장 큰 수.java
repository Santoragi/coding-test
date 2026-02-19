import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            String s = String.valueOf(numbers[i]);
            arr[i] = s;
        }
        
        Arrays.sort(arr, (o1, o2) -> - (o1 + o2).compareTo(o2 + o1));
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        for(String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}