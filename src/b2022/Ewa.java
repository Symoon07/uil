package b2022;

import java.util.*;
import java.io.*;

public class Ewa {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Ewa.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            double out = 0;
            while (n --> 0) {
                String in = f.next();
                if (in.equals("BRING")) {
                    out += Math.PI * Math.pow(f.nextDouble(), 2) * f.nextDouble();
                }
                else {
                    out -= f.nextDouble();
                }
                System.out.printf("%.2f%n", out);
            }
            System.out.println("-".repeat(10));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ewa().run();
    }
}