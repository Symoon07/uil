package b2025;

import java.util.*;
import java.io.*;

public class Julia {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Julia.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int out = 0;
            int n = f.nextInt();
            boolean[] prime = new boolean[n + 1];
            Arrays.fill(prime, true);
            for (int i = 2; i * i <= n; i++) {
                if (prime[i]) {
                    for (int j = i * i; j <= n; j += i)
                        prime[j] = false;
                }
            }
            for (int i = 2; i <= n; i++) {
                if (prime[i]) {
                    out++;
                }
            }
            System.out.println(out);
        }

        

        f.close();
    }


    public static void main(String[] args) throws Exception {
        new Julia().run();
    }

}