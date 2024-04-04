package p11_16_2023;

import java.util.*;
import java.io.*;

public class Logan {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Logan.dat"));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n --> 0) {
            int T = f.nextInt();
            int I = f.nextInt();
            int[] w = new int[I];
            int[] p = new int[I];
            String[] colors = new String[I];
            for (int i = 0; i < I; i++) {
                p[i] = f.nextInt();
                w[i] = f.nextInt();
                colors[i] = f.next();
            }
            int[][] dp = new int[I + 1][T + 1];
            for (int i = 1; i <= I; i++) {
                for (int j = 1; j <= T; j++) {
                    dp[i][j] = dp[i-1][j];
                    if (w[i-1] <= j) {
                        dp[i][j] = Math.max(dp[i-1][j], p[i-1] + dp[i-1][j-w[i-1]]);
                    }
                }
            }
            ArrayList<String> l = new ArrayList<>();
            int used = 0;
            int j = T;
            for (int i = I; i > 0; i--) {
                if (dp[i][j] != dp[i-1][j]) {
                    l.add(colors[i-1]);
                    j = j - w[i -1];
                    used += w[i -1];
                }
            }
            Collections.reverse(l);
            System.out.printf("%d\n%d\n$%d\n", T, used, dp[I][T]);
            for (String s : l) {
                System.out.println(s);
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Logan().run();
    }

}