package sammyp1;

import java.util.*;
import java.io.*;

public class Coppers {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/sammyp1/Coppers.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int[] val = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = f.nextInt(); f.nextLine();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 0; i < val.length; i++) {
                for (int j = n - val[i]; j >= 0; j--) {
                    if (dp[j]) {
                        dp[j + val[i]] = true;
                    }
                }
            }
            System.out.println(dp[n] ? "Success." : "Failure.");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Coppers().run();
    }
}