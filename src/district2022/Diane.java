package district2022;

import java.util.*;
import java.io.*;

public class Diane {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2022/Diane.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            String[] in = f.nextLine().split(" and ");
            int[] a = con(in[0].split(" "));
            int[] b = con(in[1].split(" "));
            int n = a[0] * b[1] + b[0] * a[1];
            int d = a[1] * b[1];
            int g = gcd(n, d);
            n /= g;
            d /= g;
            if (n == 0) {
                System.out.println(0);
            }
            else if (Math.abs(n) < Math.abs(d)) {
                System.out.printf("%d/%d%n", n, d);
            }
            else {
                if (n % d == 0) {
                    System.out.println(n / d);
                }
                else {
                    System.out.printf("%d %d/%d%n", n / d, n % d, Math.abs(d));
                }
            }
        }

        f.close();
    }

    public int[] con(String[] s) {
        int[] out = new int[2];
        if (s.length == 2) {
            String[] d = s[1].split("/");
            out[1] = Integer.parseInt(d[1]);
            out[0] = Integer.parseInt(s[0]) * out[1];
            out[0] += out[0] < 0 ? -Integer.parseInt(d[0]) : Integer.parseInt(d[0]);
        }
        else if (s[0].contains("/")) {
            String[] d = s[0].split("/");
            out[0] = Integer.parseInt(d[0]);
            out[1] = Integer.parseInt(d[1]);
        }
        else {
            out[0] = Integer.parseInt(s[0]);
            out[1] = 1;
        }
        return out;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        new Diane().run();
    }
}