package district2022;

import java.util.*;
import java.io.*;

public class Manos {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2022/Manos.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int a = f.nextInt(), b = f.nextInt();
            System.out.println(a == b ? "P2" : "P1");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Manos().run();
    }
}