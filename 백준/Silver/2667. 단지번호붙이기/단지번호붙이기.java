import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    arr.add(bfs(i,j));
                }
            }
        }

        System.out.println(arr.size());
        Collections.sort(arr);
        for(int n : arr){
            System.out.println(n);
        }

    }

    static int bfs(int startY, int startX){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        int result = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(!visited[ny][nx] && map[ny][nx] == 1){
                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
