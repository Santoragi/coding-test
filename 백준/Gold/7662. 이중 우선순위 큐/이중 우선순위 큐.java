import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();  //작은 수 우선
            PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder()); //큰 수 우선
            HashMap<Integer, Integer> map = new HashMap<>();
            int cntInsert = 0;
            int cntDelete = 0;

            while(k --> 0) {
                st = new StringTokenizer(br.readLine(), " ");
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if(cmd == 'I') {
                    pq.add(n);
                    rpq.add(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                    cntInsert++;
                }
                else if(cmd == 'D') {
                    if(cntDelete >= cntInsert) continue;
                    if(n == 1) {
                        while(!rpq.isEmpty()){
                            int max = rpq.poll();
                            if(map.get(max) == 0) continue;
                            else{
                                map.put(max, map.get(max) - 1);
                                break;
                            }
                        }
                        cntDelete++;
                    }
                    else if(n == -1) {
                        while(!pq.isEmpty()){
                            int min = pq.poll();
                            if(map.get(min) == 0) continue;
                            else{
                                map.put(min, map.get(min) - 1);
                                break;
                            }
                        }
                        cntDelete++;
                    }
                }
            }

            if(cntDelete >= cntInsert) System.out.println("EMPTY");
            else {
                int max = 0, min = 0;
                while(!rpq.isEmpty()){
                    max = rpq.poll();
                    if(map.get(max) == 0) continue;
                    else break;
                }
                while(!pq.isEmpty()){
                    min = pq.poll();
                    if(map.get(min) == 0) continue;
                    else break;
                }
                System.out.println(max + " " + min);
            }
        }
    }
}