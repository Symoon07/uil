package district2024;

import java.util.*;
import java.io.*;

public class Lucas {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2024/Lucas.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int[] val = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(val);
            int avg = 0, d = val.length;
            if (val.length > 2) {
                for (int i = 1; i < val.length - 1; i++) {
                    avg += val[i];
                }
                d -= 2;
            }
            else {
                for (int i = 0; i < val.length; i++) {
                    avg += val[i];
                }
            }
            avg = (int) (avg / (double) d);
            System.out.printf("%02d:%02d\n", avg / 60, avg % 60);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Lucas().run();
    }
}