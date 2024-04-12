package a2022;

import java.util.*;
import java.io.*;

public class Harold {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Harold.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String n = f.next(), m = n.replaceAll("0", "");
            int pow = n.length() - 1;
            System.out.println(n + "=" + m.charAt(0) + (m.length() > 1 ? "." : "") + m.substring(1) + "*10^" + pow);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Harold().run();
    }

}