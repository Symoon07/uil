package b2025;

import java.util.*;
import java.io.*;

public class Dante {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Dante.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int a = f.nextInt(), b = f.nextInt();
            int out = 0;
            for (int i = a + 1; i < b; i++) {
                if (prime(i)) {
                    out++;
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public boolean prime (int n) {
            if (n <= 1) {
                return false;
            }
            if (n <= 3) {
                return true;
            }
            if (n % 2 == 0 || n % 3 == 0) {
                return false;
            }
            for (int i = 5; i * i <= n; i = i + 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args) throws Exception {
        new Dante().run();
    }

}