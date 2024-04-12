package a2022;

import java.util.*;
import java.io.*;

public class Ishika {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Ishika.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            int n = f.nextInt();
            int[] planks = new int[n];
            for (int i = 0; i < n; i++) {
                planks[i] = f.nextInt();
            }
            int out = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (planks[i] + planks[j] >= 20 && planks[i] + planks[j] < out) {
                        out = planks[i] + planks[j];
                    }
                }
            }
            System.out.println(out == Integer.MAX_VALUE ? "NOT POSSIBLE" : out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ishika().run();
    }

}