package a2025;

import java.util.*;
import java.io.*;

public class Filip {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2025/Filip.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t-- > 0) {
            int r = f.nextInt(), c = f.nextInt();
            String s = f.next();
            boolean fill = f.next().equals("true");
            for (int i = 0; i < r; i++) {
                if (fill || i == 0 || i == r - 1) {
                    System.out.println(s.repeat(c));
                }
                else {
                    System.out.println(s + " ".repeat(c - 2) + s);
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Filip().run();
    }

}