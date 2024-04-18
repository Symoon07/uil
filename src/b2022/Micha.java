package b2022;

import java.util.*;
import java.io.*;

public class Micha {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Micha.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        String[] p = new String[t];
        int[] occ = new int[t];
        for (int i = 0; i < t; i++) {
            p[i] = f.nextLine();
        }
        while (f.hasNext()) {
            String in = f.nextLine().toLowerCase();
            for (int i = 0; i < t; i++) {
                int idx = 0;
                int next = in.indexOf(p[i], idx);
                while (next != -1) {
                    occ[i]++;
                    idx = next + 1;
                    next = in.indexOf(p[i], idx);
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.printf("\"%s\" %d%n", p[i], occ[i]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Micha().run();
    }
}