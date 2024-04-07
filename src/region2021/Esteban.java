package region2021;

import java.util.*;
import java.io.*;

public class Esteban {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2021/Esteban.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); int tcase = 0;
        while (tcase++ < t) {
            char type = f.next().charAt(0);
            double T = f.nextInt(), H = f.nextInt();
            if (type == 'C') {
                T = 9. / 5 * T + 32;
            }
            double HI = -42.379 + 2.04901523 * T + 10.14333127 * H -  0.22475541 * T * H - .00683783 * T * T - .05481717 * H * H + .00122874 * T * T * H
                    + .00085282 * T * H * H - .00000199 * T * T * H * H;
            boolean valid = false;
            if (T >= 80) {
                if (H < 13) {
                    HI -= ((13 - H) / 4) * Math.sqrt((17 - Math.abs(T - 95)) / 17);
                }
                if (H > 85) {
                    HI += ((H - 85) / 10) * ((87 - T) / 5);
                }
                if (!(HI > 140 || (HI < T && H >= 40))) {
                    valid = true;
                }
            }
            if (type == 'C') {
                HI = 5. / 9 * (HI - 32);
            }
            System.out.println(valid ? String.format("#%d:%.1f%c", tcase, HI, type) : String.format("#%d:%.1f%c INVALID", tcase, HI, type));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Esteban().run();
    }
}