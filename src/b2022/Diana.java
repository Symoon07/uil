package b2022;

import java.util.*;
import java.io.*;

public class Diana {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Diana.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            double x1 = f.nextDouble(), y1 = f.nextDouble(), z1 = f.nextDouble(), x2 = f.nextDouble(), y2 = f.nextDouble(), z2 = f.nextDouble();
            System.out.printf("%.2f%n", Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2)));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Diana().run();
    }
}