package regional2021;

import java.util.*;
import java.io.*;

public class Terry {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2021/Terry.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(), tcase = 0;
        while (tcase++ < t) {
            int n = f.nextInt(), k = f.nextInt();
            double[] dp = new double[k + 1];
            dp[0] = 1;
            while (n --> 0) {
                int val = f.nextInt();
                double per = (100 - f.nextInt()) / 100.;
                for (int i = k; i >= 0; i--) {
                    int min = Math.min(i + val, k);
                    dp[min] = Math.max(dp[min], dp[i] * per);
                }
            }
            System.out.printf("Case #%d: %.6f\n", tcase, 100 * (1 - dp[k]));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Terry().run();
    }
}