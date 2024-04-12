package a2022;

import java.util.*;
import java.io.*;

public class Paloma {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Paloma.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[n]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Paloma().run();
    }

}