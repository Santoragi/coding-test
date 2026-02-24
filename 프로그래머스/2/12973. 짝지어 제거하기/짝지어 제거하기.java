import java.util.*;

class Solution
{
    public int solution(String s)
    {
        char[] arr = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }

            if(arr[i] == stack.peek()) {
                stack.pop();
            }
            else {
                stack.push(arr[i]);
            }
        }
        
        int result = 0;
        if(stack.isEmpty()) result = 1;
        
        return result;
    }
}