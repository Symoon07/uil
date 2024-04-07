package region2011;

import java.util.*;
import java.io.*;

public class Apartments {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2011/Apartments.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int m = f.nextInt();
            int t = 0;
            int empty = 0;
            for (int i = 0; i < m; i++) {
                f.nextInt();
                t += f.nextInt();
            }
            System.out.println((double) t / m > 4 ? "NO " + empty : "YES " + empty);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Apartments().run();
    }

}