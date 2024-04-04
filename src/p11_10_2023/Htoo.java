package p11_10_2023;

import java.awt.geom.Line2D;
import java.util.*;
import java.io.*;

public class Htoo {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("src/htoo.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {
            String one = f.nextLine();
            String two = f.nextLine();
            int a = Integer.parseInt(one.substring(1,2));
            int b = Integer.parseInt(one.substring(4, 5));
            int c = Integer.parseInt(one.substring(10, 11));
            int d = Integer.parseInt(one.substring(13, 14));
            int e = Integer.parseInt(two.substring(1,2));
            int g = Integer.parseInt(two.substring(4, 5));
            int h = Integer.parseInt(two.substring(10, 11));
            int i = Integer.parseInt(two.substring(13, 14));

            System.out.println(Line2D.linesIntersect(a, b, c, d, e, g, h, i) ? "INTERSECT" : "NO INTERSECTION");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Htoo().run();
    }

}