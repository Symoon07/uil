package district2024;

import java.util.*;
import java.io.*;

public class Bodhi {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2024/Bodhi.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            double pv = f.nextDouble(), rate = f.nextDouble();
            int p = f.nextInt(), n = f.nextInt();
            double fv = pv * Math.pow(1 + rate / p / 100, n);
            System.out.printf("$%.2f $%.2f\n", fv, fv - pv);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bodhi().run();
    }
}