package p11_16_2023;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Linus {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Linus.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int a = f.nextInt(), b = f.nextInt();
            int d = new BigInteger(String.valueOf(a)).gcd(new BigInteger(String.valueOf(b))).intValue();
            a /= d;
            b /= d;
            if (a >= b) {
                if (a % b == 0) {
                    System.out.printf("%d\n", a / b);
                }
                else {
                    System.out.printf("%d %d/%d\n", a / b, a % b, b);
                }
            }
            else if (a == 0) {
                System.out.println(0);
            }
            else {
                System.out.printf("%d/%d\n", a, b);
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Linus().run();
    }

}