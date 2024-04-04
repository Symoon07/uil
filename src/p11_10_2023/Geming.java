package p11_10_2023;

import java.util.*;
import java.io.*;

public class Geming {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("geming.dat"));
        //Scanner f = new Scanner(System.in);
        while ((f.hasNext())) {
            int num = f.nextInt();
            int out = 0;
            if (num <= 0) {
                out = Math.abs(num) - 1;
            }
            if (num > 0) {
                out = num - num * 2 - 1;
            }
            System.out.println(num + " " + out);
        }


        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Geming().run();
    }

}