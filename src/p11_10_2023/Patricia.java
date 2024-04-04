package p11_10_2023;

import java.util.*;
import java.io.*;

public class Patricia {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("src/patricia.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int times = f.nextInt();
            int red  = f.nextInt();
            int green = f.nextInt();
            int total = red + green;
            if (times == 1) {
                String color = f.next();
                System.out.println(color.equals("R") ? red + "/" + total : green + "/" + total);
            }
            else {
                String replace = f.next();
                String color1 = f.next();
                String color2 = f.next();
                int color1num = color1.equals("G") ? green : red;
                int color2num = color2.equals("G") ? green : red;
                int top = color1num * color2num;
                int bottom;
                if (replace.equals("Y")) {
                    bottom = total * total;
                }
                else {
                    bottom = total * (total - 1);
                }
                System.out.println("" + top + "/" + bottom);

            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Patricia().run();
    }

}