import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N + 1];
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            arr[i] = pokemon;
            map.put(pokemon, i);
        }

        for(int i = 0; i < M; i++) {
            String pokemon = br.readLine();
            try {
                int n = Integer.parseInt(pokemon);
                System.out.println(arr[n]);
            }
            catch(NumberFormatException e) {
                System.out.println(map.get(pokemon));
            }
        }

    }

}