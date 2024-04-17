package a2022;

import java.util.*;
import java.io.*;

public class Mia {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Mia.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(), tcase = 0;
        while (tcase++ < t) {
            int n = f.nextInt();
            HashSet<Integer> hs = new HashSet<>();
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (f.nextInt() == 1) {
                        hs.add(j);
                        l.add(j);
                    }
                }
            }
            ArrayList<Integer> inc = new ArrayList<>(l);
            Collections.sort(inc);
            System.out.printf("Matrix %d: ", tcase);
            System.out.println((hs.size() == n && hs.size() == l.size()) ? l.equals(inc) ? "Identity Matrix - No swaps needed" : "Identity Matrix - Swaps needed" : "This is not an Identity Matrix");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Mia().run();
    }
}