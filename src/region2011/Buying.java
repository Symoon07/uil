package region2011;

import java.util.*;
import java.io.*;

public class Buying {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2011/Buying.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            String[] line = f.nextLine().split("--");
            int p = Integer.parseInt(line[2]);
            int mpg = Integer.parseInt(line[1]);
            double oldmpg = 24000.0 / 12 * 2.65;
            System.out.printf("%s $%d $%.2f\n", line[0], p - 4500, oldmpg - (24000.0 / mpg * 2.65));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Buying().run();
    }

}