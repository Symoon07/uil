package b2025;

import java.util.*;
import java.io.*;

public class Hulin {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Hulin.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        int[] n = new int[86401];
        while (t --> 0) {
            for (int i = 0; i < 3; i++) {
                int a = f.nextInt(), b = f.nextInt();
                for (int j = a; j <= b; j++) {
                    n[j]++;
                }
            }
        }
        Arrays.sort(n);
        System.out.println(n[86400]);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Hulin().run();
    }

}