package b2022;

import java.util.*;
import java.io.*;

public class Harry {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Harry.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String in = f.next(), r = f.next();
            in = in.replaceAll("[" + r + "]", "");
            System.out.println(in.isEmpty() ? "ALL LETTERS ARE GONE" : in);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Harry().run();
    }
}