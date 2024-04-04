package p11_16_2023;

import java.util.*;
import java.io.*;

public class Vicente {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Vicente.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String og = f.next();
            boolean even = f.next().equals("EVEN");
            if ((og.replaceAll("0", "").length() % 2 == 0 && even) || (og.replaceAll("0", "").length() % 2 == 1 && !even)) {
                System.out.printf("%X %X\n", Long.valueOf(og, 2), Long.valueOf(og + "0", 2));
            }
            else {
                System.out.printf("%X %X\n", Long.valueOf(og, 2), Long.valueOf(og + "1", 2));
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Vicente().run();
    }

}