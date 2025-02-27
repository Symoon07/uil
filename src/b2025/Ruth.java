package b2025;

import java.util.*;
import java.io.*;

public class Ruth {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Ruth.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int[] val = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int l = 0, r = val.length - 1;
            int lm = val[0], rm = val[val.length - 1];
            int out = 0;
            while (l <= r) {
                if (lm < rm) {
                    if (lm - val[l] > 0) {
                        out += lm - val[l];
                    }
                    lm = Math.max(lm, val[l]);
                    l++;
                }
                else {
                    if (rm - val[r] > 0) {
                        out += rm - val[r];
                    }
                    rm = Math.max(rm, val[r]);
                    r--;
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ruth().run();
    }

}