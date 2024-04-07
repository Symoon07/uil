package region2010;

import java.util.*;
import java.io.*;

public class Vectors {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2010/vectors.dat"));
        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            String[] line = f.nextLine().split(" ");
            int xs = 0;
            int ys = 0;
            for (String s : line) {
                s = s.substring(1, s.length()-1);
                int x = Integer.parseInt(s.substring(0, s.indexOf(",")));
                int y = Integer.parseInt(s.substring(s.indexOf(",")+1));
                xs += x;
                ys += y;
            }
            System.out.println("(" + xs + "," + ys + ")");
        }
    }

    public static void main(String[] args) throws Exception {
        new Vectors().run();
    }

}