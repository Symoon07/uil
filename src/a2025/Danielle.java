package a2025;

import java.util.*;
import java.io.*;

public class Danielle {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2025/Danielle.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t-- > 0) {
            int[] val = Arrays.stream(f.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int out = 1 + (val[0] - 1) + (val[1] - 2) * 9 + (val[2] - 3) * 72 + (val[3] - 4) * 504;
            System.out.println(out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Danielle().run();
    }

}