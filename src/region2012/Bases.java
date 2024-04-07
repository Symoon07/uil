package region2012;

import java.util.*;
import java.io.*;

public class Bases {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2012/Bases.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        System.out.println("Base 10   Base 2   Base 4   Base 8   Base 12   Base 16");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", i, Integer.toString(i, 2), Integer.toString(i, 4), Integer.toString(i, 8), Integer.toString(i, 12), Integer.toString(i, 16));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bases().run();
    }

}