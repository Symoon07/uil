package district2022;

import java.util.*;
import java.io.*;

public class Facundo {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2022/Facundo.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String in = f.next();
            int n = f.nextInt();
            while (n --> 0) {
                String out = "";
                int i = in.length() - 1;
                while (i > ((in.length() - 1) / 2) && i - in.length() / 2 >= 0) {
                    out = "" + in.charAt(i) + in.charAt(i - in.length() / 2) + out;
                    i--;
                }
                if (in.length() % 2 == 1) {
                    out = in.charAt(0) + out;
                }
                in = out;
            }
            System.out.println(in);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Facundo().run();
    }
}