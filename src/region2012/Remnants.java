package region2012;

import java.util.*;
import java.io.*;

public class Remnants {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2012/Remnants.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int n = f.nextInt() * 3;
            System.out.println(n % 14 == 0 ? n / 14 : n / 14 + 1);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Remnants().run();
    }

}