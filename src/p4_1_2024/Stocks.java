package p4_1_2024;

import java.util.*;
import java.io.*;

public class Stocks {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Stocks.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int x = f.nextInt(), d = f.nextInt(), m = f.nextInt();
            int[][] mat = new int[x][d];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < d; j++) {
                    mat[i][j] = f.nextInt();
                }
            }
            for (int i = 1; i < d; i++) {
                int[] v = new int[x];
                int[] w = new int[x];
                for (int j = 0; j < x; j++) {
                    v[j] = mat[j][i] - mat[j][i - 1];
                    w[j] = mat[j][i - 1];
                }
                int[][] dp = new int[x + 1][m + 1];
                for (int j = 1; j <= x; j++) {
                    for (int k = 1; k <= m; k++) {
                        dp[j][k] = dp[j - 1][k];
                        if (k >= w[j - 1]) {
                            dp[j][k] = Math.max(dp[j][k], dp[j][k - w[j - 1]] + v[j - 1]);
                        }
                    }
                }
                m += dp[x][m];
            }
            System.out.println("$" + m);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Stocks().run();
    }

}