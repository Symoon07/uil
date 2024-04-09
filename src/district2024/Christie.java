package district2024;

import java.util.*;
import java.io.*;

public class Christie {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2024/Christie.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int a = f.nextInt(), b = f.nextInt();
            String out = "";
            for (int i = a; i <= b; i++) {
                int sum = 0;
                int cur = i;
                while (cur > 0) {
                    sum += (cur % 10) * (cur % 10);
                    cur /= 10;
                }
                if (Math.sqrt(sum) == (int) Math.sqrt(sum)) {
                    out += i + " ";
                }
            }
            System.out.println(out.isEmpty() ? "NONE" : out.trim());
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Christie().run();
    }
}