package a2022;

import java.util.*;
import java.io.*;

public class Carolina {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Carolina.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        double total = 0, tax = 0;
        while (f.hasNext()) {
            String[] l = f.nextLine().split(" ");
            String item = "";
            double p = Double.parseDouble(l[0]);
            for (int i = 1; i < l.length; i++) {
                item += l[i] + " ";
            }
            System.out.printf("$%.2f + $%.2f = %.2f %s%n", p, p * .0825, p * 1.0825, item.trim());
            total += p;
            tax += p * .0825;
        }
        System.out.printf("$%.2f + $%.2f = $%.2f Combined Single Purchase%n", total, tax, total + tax);
        System.out.printf("$%.2f Sum of Individual Purchases%n", total + tax);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Carolina().run();
    }

}