package state2023;

import java.util.*;
import java.io.*;

public class Kumar {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Kumar.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String in = f.next();
            if (in.contains("...")) {
                int num1 = 0, dem1 = 0, num2 = 0, dem2 = 0;
                for (int i = 1; i < in.length(); i++) {
                    String inn = in.substring(i);
                    int idx = 0, rlen = 0;
                    String res = "";
                    int[][] dp = new int[inn.length() + 1][inn.length() + 1];
                    for (int j = 1; j < dp.length; j++) {
                        for (int k = j + 1; k < dp.length; k++) {
                            if (inn.charAt(j - 1) == inn.charAt(k - 1) && dp[j - 1][k - 1] < (k - j)) {
                                dp[j][k] = dp[j - 1][k - 1] + 1;
                                if (dp[j][k] > rlen) {
                                    rlen = dp[j][k];
                                    idx = Math.max(idx, j);
                                }
                            }
                            else {
                                dp[j][k] = 0;
                            }
                        }
                    }
                    if (rlen > 0) {
                        for (int j = idx - rlen + 1; j <= idx; j++) {
                            res += inn.charAt(j - 1);
                        }
                    }
                    boolean valid = true;
                    for (int j = idx - (3 * rlen) + 1; j <= idx; j+= rlen) {
                        if (!inn.substring(j, j + rlen).equals(res)) {
                            valid = false;
                        }
                    }
                    if (valid) {
                        num1 = Integer.parseInt(res);

                    }
                }
            }
            else {
                long num = Long.parseLong(in.substring(1));
                long dem = (long) Math.pow(10, in.length() - 1);
                long gcd = gcd(num, dem);
                num /= gcd;
                dem /= gcd;
                System.out.printf("%s is equivalent to %d/%d%n", in, num, dem);
            }
        }

        f.close();
    }

    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        new Kumar().run();
    }

}