import java.io.*;
import java.util.*;

public class Main {

    static String key, encode;
    static char[][] board;
    static int[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        key = br.readLine();
        encode = br.readLine();

        int N = encode.length()/key.length();
        int M = key.length();
        board = new char[encode.length()/key.length()][key.length()];

        int idx = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                board[j][i] = encode.charAt(idx);
                idx++;
            }
        }

        graph = new int[key.length()];
        visited = new boolean[key.length()];
        Arrays.fill(graph, -1);

        char[] arr = key.toCharArray();
        Arrays.sort(arr);
        String sortedKey = String.valueOf(arr);

        for(int i = 0; i < key.length(); i++) {
            char c1 = key.charAt(i);
            for(int j = 0; j < sortedKey.length(); j++) {
                char c2 = sortedKey.charAt(j);

                if(c1 == c2 && !visited[j]) {
                    graph[i] = j;
                    visited[j] = true;
                    break;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < graph.length; j++) {

                sb.append(board[i][graph[j]]);
            }
        }

        System.out.println(sb);
    }
}