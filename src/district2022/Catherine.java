package district2022;

import java.util.*;
import java.io.*;

public class Catherine {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2022/Catherine.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String a = f.next(), b = f.next();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    System.out.print(a.substring(i, i + 1).toUpperCase());
                }
                else if (a.contains("" + b.charAt(i))) {
                    System.out.print(b.charAt(i));
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Catherine().run();
    }
}