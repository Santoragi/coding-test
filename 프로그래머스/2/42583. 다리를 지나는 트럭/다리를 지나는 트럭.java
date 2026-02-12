import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        
        
        int total = 0;
        int time = 0;
        for(int truck : truck_weights){
            while(true) {
                if(q.isEmpty()) {
                    time++;
                    total += truck;
                    q.add(truck);
                    break;
                } 
                else if(q.size() == bridge_length) {
                    total -= q.poll();
                } 
                else {
                    if(total + truck <= weight) {
                        time++;
                        total += truck;
                        q.add(truck);
                        break;
                    }
                    else {
                        time++;
                        q.add(0);
                    }
                }
            }
        }
        time += bridge_length;
        
        return time;
    }
}