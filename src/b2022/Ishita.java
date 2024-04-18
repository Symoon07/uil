package b2022;

import java.util.*;
import java.io.*;

public class Ishita {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Ishita.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        run : while (t --> 0) {
            char[] in = f.nextLine().toCharArray();
            int cnt = 0;
            int temp = 0;
            for (char c : in) {
                if (c == ')') {
                    temp--;
                    if (temp < 0) {
                        System.out.println(0);
                        continue run;
                    }
                    else if (temp == 0) {
                        cnt++;
                    }
                }
                else {
                    temp++;
                }
            }
            if (temp != 0) {
                System.out.println(0);
                continue;
            }
            System.out.println((1 << cnt - 1) - 1);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Ishita().run();
    }
}