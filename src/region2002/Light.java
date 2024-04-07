package region2002;

import java.util.*;
import java.io.*;

public class Light {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2002/Light.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            double l = f.nextDouble();
            double d = f.nextDouble();
            double h = f.nextDouble();
            double r = h * d;
            double area = Math.PI * Math.pow(r, 2);
            System.out.printf("%.2f\n", area * l / 14.0);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Light().run();
    }

}