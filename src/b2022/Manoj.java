package b2022;

import java.util.*;
import java.io.*;

public class Manoj {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Manoj.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int a = f.nextInt(), b = f.nextInt(), c = f.nextInt();
            String con = f.next() + f.next();
            double C = 100, F = 180, M = b - a;
            switch (con) {
                case "MC" -> {
                    System.out.printf("%d degrees M = %d degrees C%n", c, Math.round((c - a) * (C / M)));
                }
                case "MF" -> {
                    System.out.printf("%d degrees M = %d degrees F%n", c, Math.round((c - a) * (F / M) + 32));
                }
                case "CF" -> {
                    System.out.printf("%d degrees C = %d degrees F%n", c, Math.round(c * (9. / 5)) + 32);
                }
                case "CM" -> {
                    System.out.printf("%d degrees C = %d degrees M%n", c, Math.round(c * (M / C) + a));
                }
                case "FC" -> {
                    System.out.printf("%d degrees F = %d degrees C%n", c, Math.round((c - 32) * (5. / 9)));
                }
                case "FM" -> {
                    System.out.printf("%d degrees F = %d degrees M%n", c, Math.round((c - 32) * (M / F)) + a);
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Manoj().run();
    }
}