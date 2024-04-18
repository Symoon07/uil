package b2022;

import java.util.*;
import java.io.*;

public class Carolyn {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Carolyn.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String in = f.next();
            char a = in.charAt(0), b = in.charAt(1);
            if (a <= b) {
                for (int i = a; i <= b; i++) {
                    for (int j = 0; j <= i - a; j++) {
                        System.out.print((char) i);
                    }
                    System.out.println();
                }
            }
            else {
                for (int i = a; i >= b; i--) {
                    for (int j = 0; j <= a - i; j++) {
                        System.out.print((char) i);
                    }
                    System.out.println();
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Carolyn().run();
    }
}