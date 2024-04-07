package region2009;

import java.util.*;
import java.io.*;


public class Exponents {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("exponents.dat"));

        while (f.hasNext()) {
            int n = f.nextInt();
            long np = f.nextLong();
            int p = 1;
            for (int i = 1; i <= 15; i++) {
                if (Math.pow(n, i) == np) {
                    p = i;
                    break;
                }
            }
            System.out.println(p);
        }
    }
    public static void main(String[] args) throws Exception{
        new Exponents().run();
    }
}