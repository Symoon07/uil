package region2009;

import java.util.*;
import java.io.*;

public class House {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2009/House.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            double zero = f.nextInt() / 100.0;
            double one = f.nextInt() / 100.0;
            String b = Integer.toBinaryString(f.nextInt());
            double total = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '1') {
                    total += one;
                }
                else {
                    total += zero;
                }
            }
            System.out.printf("%s $%.2f\n", b, total);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new House().run();
    }

}