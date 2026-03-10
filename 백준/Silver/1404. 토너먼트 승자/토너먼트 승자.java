import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double[][] p = new double[8][8];

        // 입력 28개를 상삼각 형태로 읽기
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++) {
                double win = Double.parseDouble(st.nextToken()) / 100.0;
                p[i][j] = win;
                p[j][i] = 1.0 - win;
            }
        }

        double[] round1 = new double[8];
        double[] round2 = new double[8];
        double[] winner = new double[8];

        // 1라운드 통과 확률
        for (int i = 0; i < 8; i += 2) {
            round1[i] = p[i][i + 1];
            round1[i + 1] = p[i + 1][i];
        }

        // 2라운드(결승 진출) 확률
        for (int group = 0; group < 8; group += 4) {
            // group, group+1 vs group+2, group+3
            round2[group] = round1[group] *
                    (round1[group + 2] * p[group][group + 2]
                            + round1[group + 3] * p[group][group + 3]);

            round2[group + 1] = round1[group + 1] *
                    (round1[group + 2] * p[group + 1][group + 2]
                            + round1[group + 3] * p[group + 1][group + 3]);

            round2[group + 2] = round1[group + 2] *
                    (round1[group] * p[group + 2][group]
                            + round1[group + 1] * p[group + 2][group + 1]);

            round2[group + 3] = round1[group + 3] *
                    (round1[group] * p[group + 3][group]
                            + round1[group + 1] * p[group + 3][group + 1]);
        }

        // 우승 확률
        for (int i = 0; i < 4; i++) {
            winner[i] = round2[i] *
                    (round2[4] * p[i][4]
                            + round2[5] * p[i][5]
                            + round2[6] * p[i][6]
                            + round2[7] * p[i][7]);
        }

        for (int i = 4; i < 8; i++) {
            winner[i] = round2[i] *
                    (round2[0] * p[i][0]
                            + round2[1] * p[i][1]
                            + round2[2] * p[i][2]
                            + round2[3] * p[i][3]);
        }

        DecimalFormat df = new DecimalFormat("0.0#########");

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 8; i++) {
            sb.append(df.format(winner[i]));
            if(i < 7) sb.append(" ");
        }

        System.out.println(sb);
    }
}