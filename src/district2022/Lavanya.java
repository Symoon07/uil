package district2022;

import java.util.*;
import java.io.*;

public class Lavanya {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2022/Lavanya.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            ArrayList<Integer> l = new ArrayList<>();
            StringBuilder out = new StringBuilder(n + " = ");
            while (n % 2 == 0) {
                l.add(2);
                n /= 2;
            }
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                while (n % i == 0) {
                    l.add(i);
                    n /= i;
                }
            }
            if (n > 2) {
                l.add(n);
            }
            for (int m : l) {
                out.append(m).append(" * ");
            }
            System.out.println(out.substring(0, out.length() - 3));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Lavanya().run();
    }
}