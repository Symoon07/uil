package district2024;

import java.util.*;
import java.io.*;

public class Jennifer {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2024/Jennifer.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt(), d = f.nextInt();
            int g = gcd(n, d);
            n /= g;
            d /= g;
            System.out.printf("%d %d\n", d - n, n);
        }

        f.close();
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        new Jennifer().run();
    }
}