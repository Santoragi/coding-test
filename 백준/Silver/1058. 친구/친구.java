import java.io.*;

public class Main {

    static int N;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                if(line.charAt(j) == 'Y'){
                    dist[i][j] = 1;
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            int ctn = 0;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(dist[i][j] <= 2) ctn++;
            }
            result = Math.max(ctn, result);
        }

        System.out.println(result);
    }
}
