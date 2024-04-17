package a2022;

import java.util.*;
import java.io.*;

public class Krish {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Krish.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int sum = 0;
            int product = 1;
            int rev = 0;
            int cur = n;
            while (cur != 0) {
                sum += cur % 10;
                rev = 10 * rev + cur % 10;
                if (cur % 10 != 0) {
                    product *= cur % 10;
                }
                cur /= 10;
            }
            System.out.printf("%d %d %d %d %d%n", n, sum, product, rev, (long) n * rev);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Krish().run();
    }
}