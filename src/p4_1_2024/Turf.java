package p4_1_2024;

import java.awt.*;
import java.util.*;
import java.io.*;

public class Turf {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Turf.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                String[] s = f.next().replaceAll("[()]", "").split(",");
                x[i] = Integer.parseInt(s[0]);
                y[i] = Integer.parseInt(s[1]);
            }
            Polygon p = new Polygon(x, y, n);
            String[] s = f.next().replaceAll("[()]", "").split(",");
            System.out.println(p.contains(Integer.parseInt(s[0]), Integer.parseInt(s[1])) ? "your turf!" : "keep out!");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Turf().run();
    }

}