package b2022;

import java.util.*;
import java.io.*;

public class Tomas {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Tomas.dat"));
        //Scanner f = new Scanner(System.in);

        String[] alpha = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            f.nextLine();
            String[] in = f.nextLine().split(" ");
            String out = "";
            for (String cur : in) {
                int n = Integer.parseInt("" + cur.charAt(0));
                if (n == 0) {
                    out += " ";
                }
                else {
                    if (n == 9 || n == 7) {
                        out += alpha[n - 2].charAt((cur.length() - 1) % 4);
                    }
                    else {
                        out += alpha[n - 2].charAt((cur.length() - 1) % 3);
                    }
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Tomas().run();
    }
}